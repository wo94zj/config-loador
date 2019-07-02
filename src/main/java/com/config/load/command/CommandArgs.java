package com.config.load.command;

import java.util.Map;

/**
 * 
 * @author zhaoj
 * 
 * 加载命令行配置信息
 * 直接参数通过getArgs()获取；“-”开头的参数格式为“-key value”，“--”开头的参数格式为“--key=value”，通过getValue获取
 */
public class CommandArgs {

	private String[] params = null;
	private Map<String, String> map =null;
	
	protected void initArgs(String[] params, Map<String, String> map) {
		this.params = params;
		this.map = map;
	}
	
	public String[] getArgs() {
		return params;
	}
	
	public String getValue(String key) {
		return map.get(key);
	}
	
	public String getValue(String key, String defaultValue) {
		return map.getOrDefault(key, defaultValue);
	}
}
