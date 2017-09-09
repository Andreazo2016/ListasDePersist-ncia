package classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.PageIterator;

public class Main {
	public static void main(String[] args) throws IOException, SAXException {
		//new Metodos().SalvarInformacao();
		
		//new Xml().SaveToCsv();
		
		
		PDDocument pdf  =  PDDocument.load(new File(System.getProperty("user.home")+"/lista03.pdf"));
		ObjectExtractor ext =  new ObjectExtractor(pdf);
		Page Page = ext.extract(1);
		
		
		
		
		
		
		
		
		
		
		
	}

}
