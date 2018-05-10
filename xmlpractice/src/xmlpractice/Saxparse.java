package xmlpractice;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Saxparse {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory sf=SAXParserFactory.newInstance();
		SAXParser sp=sf.newSAXParser();
		InputStream in=Saxparse.class.getClassLoader().getResourceAsStream("hehe.xml");
		sp.parse(in,new sax());
		
		
		
	}
}
