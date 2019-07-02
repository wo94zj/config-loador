package com.config.load;

import java.util.Properties;

import com.config.load.command.CommandProvider;
import com.config.load.property.PropertiesProvider;

public class ConfigProviderFactory {

	private ConfigProviderFactory() {
	}
	
	/**
	 * 提供Properties配置解析
	 * @param configPath 配置文件路径
	 * @return IConfigProvider<Properties>
	 */
	public static IConfigProvider<Properties> createPropertiesProvider(String configPath) {
		IConfigProvider<Properties> property = new PropertiesProvider(configPath);
		return property;
	}
	
	/**
	 * 
	 * @param args 命令行参数
	 * @return
	 */
	public static IConfigProvider<String[]> createCommandProvider(String[] args) {
		IConfigProvider<String[]> command = new CommandProvider(args);
		return command;
	}
}
