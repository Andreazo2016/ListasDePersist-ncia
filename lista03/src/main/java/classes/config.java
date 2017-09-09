package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class config {
	
	 Properties propriedade;
	
	public config() {
		this.propriedade =  new Properties();
	}
	
	public boolean arquivoExiste() throws IOException{
		try {
           propriedade.load(new FileInputStream(System.getProperty("user.home") + "/config.properties"));
            System.out.println("arquivo encontrado");
            return true;
        }catch (FileNotFoundException ex){
            System.out.println("arquivo nao encontrado");
            return false;
        }
        
		
	}
	public boolean criarArquivo() throws FileNotFoundException, IOException{
		if(!arquivoExiste()){
			propriedade.setProperty("path", System.getProperty("user.home")+"/config.csv");
			propriedade.store(new FileOutputStream(System.getProperty("user.home") + "/config.properties"),null);
			System.out.println("Arquivo criado com sucesso");
			return true;
		}
		System.out.println("Arquivo ja existe");
		return false;
	}

}
