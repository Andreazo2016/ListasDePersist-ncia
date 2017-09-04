package app.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class Servicos {
	
	/*Comando cat em Java*/
	public void Cat() throws IOException{
		Properties pro = new Properties();
		pro.load(new FileInputStream("config.properties"));
		String Path = pro.getProperty("filePath");
		if(Path == null){
			pro.setProperty("filePath",System.getProperty("user.home") + "/config/Contato.csv");
			pro.store(new FileOutputStream("config.properties"),null);	
		}
		try {
			
			BufferedReader buffer = new BufferedReader(new FileReader(Path));
			String linha ="";
			while((linha =  buffer.readLine()) != null){
				System.out.println(linha);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*Comando Head em Java*/
	public String Head(int lines) throws IOException {
		Properties pro = new Properties();
		pro.load(new FileInputStream("config.properties"));
		String Path = pro.getProperty("filePath");
		if(Path == null){
			pro.setProperty("filePath",System.getProperty("user.home") + "/config/Contato.csv");
			pro.store(new FileOutputStream("config.properties"),null);	
		}
		int i = 0;
		try {
			BufferedReader buf = new BufferedReader(new FileReader(Path));
			String linha = "";
			while ((linha =  buf.readLine()) != null){
				if(i == lines){ 
				return null;
				}else{
					System.out.println(linha + "\n");
					i++;
				}
				
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*Comando WC em Java */
	public void WC() throws IOException{
		long countLine = 0;
		long CountChar = 0;
		long CountWord = 0;
		Properties pro = new Properties();
		pro.load(new FileInputStream("config.properties"));
		String Path = pro.getProperty("filePath");
		if(Path == null){
			pro.setProperty("filePath",System.getProperty("user.home") + "/config/Contato.csv");
			pro.store(new FileOutputStream("config.properties"),null);	
		}
		try {
			BufferedReader buf = new BufferedReader(new FileReader(Path));
			String linha = "";
			 
			while ((linha =  buf.readLine()) != null){
				CountChar += linha.length();
				countLine++;
				CountWord+= linha.split("[^\\w]+").length;
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Numero de Linhas " + countLine);
		System.out.println("Numero de Char " + CountChar);
		System.out.println("Numero de Words " + CountWord);
	
	}
	public void CopyArchive() throws IOException{
		Properties pro = new Properties();
		pro.load(new FileInputStream("config.properties"));
		String Path1 = pro.getProperty("entrada");
		String Path2 = pro.getProperty("saida");
		FileInputStream input = new FileInputStream(Path1);
		FileOutputStream out = new FileOutputStream(Path2);
		int ret = 0;
		byte [] array = new byte[8];
		while(ret > -1){
			ret = input.read(array);
			out.write(array);
			out.flush();
		}
		input.close();
		out.close();
	}

}
