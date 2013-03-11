package com.mackstore.utils.misc;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class CarregaProperties {
	public Properties carregaProperties(String nomeArquivo) throws IOException{
		URL url = this.getClass().getResource("/"+nomeArquivo);
		FileInputStream fileInput = new FileInputStream(url.getFile());
		Properties properties = new Properties();
		properties.load(fileInput);
		return properties;
	}
}
