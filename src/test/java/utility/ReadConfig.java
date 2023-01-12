package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() throws Exception {

		FileInputStream fis = new FileInputStream("./testData/config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String appURL() {

		return prop.getProperty("URL");

	}

	
	public String getUsername() {

		return prop.getProperty("Username");

	}

	public String getPassword() {

		return prop.getProperty("Password");

	}

}
