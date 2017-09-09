package classes;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xml {
	public void SaveToCsv() throws SAXException, IOException{
		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder doc = dbf.newDocumentBuilder();
			Document xml =  doc.parse(System.getProperty("user.home") + "/fornecedores.xml");
			Element raiz = xml.getDocumentElement();
			OutputStream out  = new FileOutputStream(System.getProperty("user.home")+"/fornecedores.csv",true);
			OutputStreamWriter or = new OutputStreamWriter(out);
			BufferedWriter bf = new BufferedWriter(or);
			System.out.println("Elemento Raiz: " + raiz.getNodeName());
			
			NodeList lista = raiz.getElementsByTagName("resource");
			
			String linha = "";
			for(int i = 0; i< lista.getLength();i++){
				Node node =  lista.item(i);
				if(node.getNodeType() == node.ELEMENT_NODE){
					Element el = (Element) node;
					NodeList novaLista = el.getChildNodes();
					
					for(int j = 0; j < novaLista.getLength(); j++){
						Node no = novaLista.item(j);
						if(no.getNodeType() ==  no.ELEMENT_NODE){
							System.out.println(no.getTextContent());
							if (!no.getTextContent().isEmpty()){
								linha+= no.getTextContent() + ",";
							}
							
						}
					}
					
					bf.write(linha);
					bf.newLine();
					linha = "";
					
				}
				
				
			}
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
