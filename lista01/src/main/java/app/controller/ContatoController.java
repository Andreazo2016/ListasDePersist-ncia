package app.controller;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.config.Settings;
import app.model.Contato;
import app.service.ContatoCSV;

@Controller
public class ContatoController {
	
	@RequestMapping("/")
	public String home() throws FileNotFoundException, IOException{
		return "forward:/index.html";
	}
	
	@RequestMapping("/Contato/add")
	public String adicionarContato(Contato contato) throws FileNotFoundException, IOException{
		ContatoCSV contatoCSV = new ContatoCSV();
		contatoCSV.addContato(contato);
		return "redirect:/";
	}
	@RequestMapping("/allContato")
	@ResponseBody
	public List<Contato> AllContato() throws FileNotFoundException, IOException{
		ContatoCSV contatoCSV = new ContatoCSV();
		return contatoCSV.AllContato();
		
	}

	
}
