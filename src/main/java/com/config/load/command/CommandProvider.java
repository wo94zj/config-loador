package com.config.load.command;

import com.config.load.IConfigProvider;
import com.config.load.exception.ConfigException;

public class CommandProvider implements IConfigProvider<String[]> {

	private String[] args;
	
	public CommandProvider(String[] args) {
		this.args = args;
	}

	@Override
	public String[] provide() throws ConfigException {
		return args;
	}

}
