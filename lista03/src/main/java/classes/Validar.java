package classes;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class Validar {

	public static void main(String[] args) {
		String XSD = System.getProperty("user.home" )+ "/xml/contatoValidator.xsd";
		String XML = System.getProperty("user.home") + "/xml/contato.xml";
		
		boolean isValid = Validar.validarXML(XSD,XML);
		if(isValid){
			System.out.println("XML Válido!!!");
		}else{
			System.out.println("XML Não Válido!!!");
		}
		
		
	}
	
	
	public  static  boolean validarXML(String pathXSD, String pathXML){
		
		try {
			SchemaFactory factory =  SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema( new File(pathXSD) );
			Validator validador = schema.newValidator();
			validador.validate( new StreamSource(new File(pathXML)));
		} catch (SAXException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}
