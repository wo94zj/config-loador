package com.config.load.command;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.config.load.AbstractConfigLoader;
import com.config.load.IConfigProvider;

public class CommandArgsLoader extends AbstractConfigLoader<CommandArgs, String[]>{

	public CommandArgsLoader(IConfigProvider<String[]> provider) {
		super(provider);
	}
	
	@Override
	public CommandArgs load(String[] args) {
		if(args == null || args.length <=0) {
			return null;
		}
		
		List<String> params = new LinkedList<>();
		Map<String, String> map = new HashMap<>();
		
		for(int optind=0; optind<args.length; optind ++) {
			if(args[optind].startsWith("--")) {
				String[] param = args[optind].substring(2).split("=");
				if(param.length == 2) {
					map.put(param[0], param[1]);
				}
			}else if(args[optind].startsWith("-")) {
				//避免-key value配置中value不存在造成后续配置混乱问题
				if((optind+1) < args.length && args[optind+1].startsWith("-")) {
					continue;
				}
				map.put(args[optind].substring(1), args[++optind]);
			}else {
				params.add(args[optind]);
			}
		}
		
		CommandArgs command = new CommandArgs();
		command.initArgs(params.toArray(new String[params.size()]), map);
		return command;
	}

}
