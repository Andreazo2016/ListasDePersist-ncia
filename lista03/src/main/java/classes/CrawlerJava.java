package classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CrawlerJava {
	private Properties pro;
	config config;
	public CrawlerJava() {
		this.pro = new Properties();
		this.config =  new config();

	}


	public void SalvarInformacao() throws IOException{
		Document doc =  Jsoup.connect("https://www.americanas.com.br/produto/132193060/notebook-samsung-expert-x23-intel-core-i5-8gb-geforce-920mx-de-2gb-1tb-tela-15-6-led-hd-windows-10-branco?pfm_carac=Notebook&pfm_index=6&pfm_page=category&pfm_pos=grid&pfm_type=vit_product_grid").get();
		Elements links =  doc.select("a[href]");
		if(!config.arquivoExiste()){
			config.criarArquivo();
		}
		pro.load(new FileInputStream(System.getProperty("user.home") + "/config.properties"));
		String path = pro.getProperty("path");
		OutputStream out = new FileOutputStream(new File(path),true);
		OutputStreamWriter ot = new OutputStreamWriter(out);
		BufferedWriter bf = new BufferedWriter(ot);
		String linha ="";
		for(Element link:links){
			linha = link.attr("href") +","+link.text();
			bf.write(linha);
			bf.newLine();
		}
		bf.close();
		System.out.println("Dados Gravado com Sucesso!!");
	}
	

}
