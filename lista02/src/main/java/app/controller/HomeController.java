package app.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.service.Servicos;

@Controller
public class HomeController {

	@Autowired
	private Servicos servico;
	@RequestMapping("/")
	public String home() throws FileNotFoundException, IOException{
		Properties pro = new Properties();
		pro.setProperty("filePath",System.getProperty("user.home") + "/config/Contato.csv");
		pro.setProperty("entrada",System.getProperty("user.home") + "/config/entrada.bin");
		pro.setProperty("saida",System.getProperty("user.home") + "/config/saida.bin");
		pro.store(new FileOutputStream("config.properties"),null);
		return "forward: /index.html";
	}
	@RequestMapping("/wc")
	@ResponseBody
	public String wc() throws IOException{
		servico.WC();
		return "hello";
	}
	
	@RequestMapping("/head/{lines}")
	@ResponseBody
	public String head(@PathVariable(value = "lines") int lines) throws IOException{
		servico.Head(lines);
		return "OK";
	}
	@RequestMapping("/cat")
	@ResponseBody
	public String head() throws IOException{
		servico.Cat();
		return "OK";
	}
	@RequestMapping("/copy")
	@ResponseBody
	public String copia() throws IOException{
		servico.CopyArchive();
		return "Deu cerrto";
	}
	@RequestMapping("/copia")
	@ResponseBody
	public String cop(){
		return "COpia";
	}

}
