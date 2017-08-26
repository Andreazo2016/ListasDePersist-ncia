package app.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Settings {
	public void CreateProperties() throws IOException{
		Path p;
		Properties pro = new Properties();
		//String CominhoArquivo = Settings.class.getResourceAsStream("/Database/Contato.csv").toString() ;
		String CominhoArquivo = "/home/andreazo/workspace/lista01/src/main/resources/Database/Contato.csv";
		pro.setProperty("nameArquivo",CominhoArquivo);
		pro.store(new FileOutputStream("config.properties"),null);
		
	}

}
