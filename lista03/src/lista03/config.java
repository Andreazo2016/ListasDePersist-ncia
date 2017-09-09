package lista03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class config {
	
	private Properties propriedade;
	
	public config() {
		this.propriedade =  new Properties();
	}
	
	public boolean arquivoExiste(){
		try {
			propriedade.load(new FileInputStream(System.getProperty("user.home")+"/config.properties"));
			System.out.println("Arquivo existe!!");
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	public boolean criarArquivo() throws FileNotFoundException, IOException{
		if(!arquivoExiste()){
			propriedade.setProperty("path", System.getProperty("user.home")+"/config.csv");
			propriedade.store(new FileOutputStream(System.getProperty("user.home") + "/config.properties"),null);
			return true;
		}
		return false;
	}

}
