package app.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Settings {
	public void CreateProperties() throws IOException{
		//String caminhoRelativo = "/lista01/src/main/resources/Database/Contato.csv";
		Properties pro = new Properties();
		String caminhoRelativo = "config/Contato.csv";
		String CaminhoArquivo = System.getProperty("user.home") +"/"+ caminhoRelativo;
		pro.setProperty("nameArquivo",CaminhoArquivo);
		pro.store(new FileOutputStream("config.properties"),null);	
	}
	public String getPathFile() throws FileNotFoundException, IOException{
		Properties propriedade = new Properties();
		propriedade.load(new FileInputStream("config.properties"));
		String filePath = propriedade.getProperty("nameArquivo");
		return filePath;		
	}

}
