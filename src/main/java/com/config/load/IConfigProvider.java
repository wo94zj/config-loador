package com.config.load;

import com.config.load.exception.ConfigException;

public interface IConfigProvider<T> {

	public T provide()  throws ConfigException;
	
}
