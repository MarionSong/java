package xmlpractice;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParse {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		InputStream is=DomParse.class.getClassLoader().getResourceAsStream("hehe.xml");
		Document document=db.parse(is);
		list(document);
		read(document);
		add(document);
	}

	private static void add(Document document) throws TransformerException {
		Element element=document.createElement("杭州");
		element.setTextContent("杭州");
		Node parent=document.getElementsByTagName("中国").item(0);
		parent.appendChild(element);
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document),new StreamResult("hehe.xml"));
		
		
	}

	private static void read(Document document) {
		NodeList nodeList=document.getElementsByTagName("广州");
		Node node=nodeList.item(0);
		String value=node.getTextContent();
		System.out.println(value);
		
	}

	private static void list(Node node) {
		if(node.getNodeType()==Node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());
		}
		NodeList nodeList=node.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++) {
			Node child=nodeList.item(i);
			list(child);			
		}		
	}
	
	
	
	
	
	
	
}
