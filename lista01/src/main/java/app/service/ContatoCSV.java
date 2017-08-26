package app.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import app.model.Contato;

public class ContatoCSV {
	
		public void addContato(Contato contato) throws FileNotFoundException, IOException{
			Properties propriedade = new Properties();
			propriedade.load(new FileInputStream("config.properties"));
			String filePath = propriedade.getProperty("nameArquivo");
			String contatoCSV = "";
			contatoCSV += contato.getNome() +","+contato.getEmail()+","+contato.getEndereco()+","+contato.getTelefone();
			FileWriter fw = new FileWriter(filePath, true);
			BufferedWriter conexao = new BufferedWriter(fw);
			conexao.write(contatoCSV);
			conexao.newLine();
			conexao.close();
		}
		public List<Contato> AllContato() throws FileNotFoundException, IOException{
			List<Contato> listaContatos = new ArrayList<Contato>();
			Properties propriedade = new Properties();
			Contato contato = null;
			propriedade.load(new FileInputStream("config.properties"));
			String filePath = propriedade.getProperty("nameArquivo");
			
			BufferedReader bf = new BufferedReader(new FileReader(filePath));
			String linha="";
			if((linha = bf.readLine()) != null){ 
			while((linha = bf.readLine()) != null){
				String [] Contatos = linha.split(",");
				contato = new Contato();
				contato.setNome(Contatos[0]);
				contato.setEmail(Contatos[1]);
				contato.setEndereco(Contatos[2]);
				contato.setTelefone(Contatos[3]);
				listaContatos.add(contato);
			}
			}
			return listaContatos;
			
		}

}
