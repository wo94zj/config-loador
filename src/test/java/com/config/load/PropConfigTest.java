package com.config.load;

import org.junit.Test;

import com.config.load.property.CommonConfig;
import com.config.load.property.CommonConfigLoader;

public class PropConfigTest {

	@Test
	public void load() {
		 String configPath = "F:\\tmp\\tmp.properties";
		 IConfigLoader<CommonConfig> loader = new CommonConfigLoader(ConfigProviderFactory.createPropertiesProvider(configPath));
		CommonConfig config = loader.load();
		System.out.println(config.getValue("a"));
	}
}
