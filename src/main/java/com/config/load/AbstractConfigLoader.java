package com.config.load;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.config.load.exception.ConfigException;
import com.config.load.exception.ExceptionUtil;

public abstract class AbstractConfigLoader<T, U> implements IConfigLoader<T>{

	private Logger logger = LoggerFactory.getLogger(AbstractConfigLoader.class);
	
	protected IConfigProvider<U> provider;
	
	protected AbstractConfigLoader(IConfigProvider<U> provider){
		this.provider = provider;
	}
	
	@Override
	public T load() {
		try {
			return load(this.provider.provide());
		} catch (ConfigException e) {
			logger.error(ExceptionUtil.asString(e));
		}
		return null;
	}
	
	public abstract T load(U loaderSource);
}
