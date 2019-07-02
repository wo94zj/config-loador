package com.config.load.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.config.load.IConfigProvider;
import com.config.load.exception.ConfigException;
import com.config.load.exception.ExceptionUtil;

public class PropertiesProvider implements IConfigProvider<Properties> {

	private Logger logger = LoggerFactory.getLogger(PropertiesProvider.class);
	private String configPath;
	
	public PropertiesProvider(String configPath) {
		Objects.requireNonNull(configPath, "Useage:configPath connot be null");
		this.configPath = configPath;
	}
	
	@Override
	public Properties provide() throws ConfigException {
		Properties prop = new Properties();
		//path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从 ClassPath根下获取
		InputStream in = null;
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl != null) {
            	in = cl.getResourceAsStream(configPath);
            } else {
            	in = ClassLoader.getSystemResourceAsStream(configPath);
            }
			
			if(in == null){
	    		String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	    		in = new FileInputStream(new File(path.substring(0, path.lastIndexOf(File.separator)+1)+configPath));
	    	}
			
			prop.load(in);
			in.close();
		} catch (IOException e) {
			logger.error(ExceptionUtil.asString(e));
			throw new ConfigException(e);
		}
		return prop;
	}
	
}
