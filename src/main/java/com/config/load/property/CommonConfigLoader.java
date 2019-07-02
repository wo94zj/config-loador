package com.config.load.property;

import java.util.Properties;

import com.config.load.AbstractConfigLoader;
import com.config.load.IConfigProvider;

public class CommonConfigLoader extends AbstractConfigLoader<CommonConfig, Properties>{
	
	public CommonConfigLoader(IConfigProvider<Properties> provider) {
		super(provider);
	}

	@Override
	public CommonConfig load(Properties prop) {
		CommonConfig config = new CommonConfig();
		config.initProperty(prop);
		return config;
	}
	

}
