package tedu.day2102;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Test4 {
	public static void main(String[] args) throws Exception {
		Document doc = createDom();
		writeXml(doc);
	}
	
	
	
	
	
	private static Document createDom() {
		//树根
		Document doc =
		 DocumentHelper.createDocument();
		
		doc.addComment("由 Dom4j 自动生成");
		Element email = doc.addElement("email");
		email.addAttribute("date", "2018-5-11");
		email.addAttribute("time", "16:42:8");
		email.addElement("from").setText("aaa@aaa.com");
		Element to = email.addElement("to");
		to.addElement("to-email").setText("bbb@bbb.com");
		to.addElement("to-email").setText("ccc@ccc.com");
		to.addElement("to-email").setText("ddd@ddd.com");
		email.addElement("subject").setText("Hello DOM4J");   
		Element body = email.addElement("body");
		body.addText(">>>Hello Dom4j !!!<<<");
		body.addCDATA(">>>你好，多磨佛节！！！<<<");
		
		return doc;
	}

	
	
	
	
	
	
	
	
	
	private static void writeXml(Document doc) throws Exception {
		FileOutputStream out = 
		 new FileOutputStream("d:/abc/e.xml");
		OutputFormat f = 
		 //OutputFormat.createPrettyPrint();
		 OutputFormat.createCompactFormat();
		f.setEncoding("GBK");
		
		XMLWriter writer = new XMLWriter(out, f); 
		writer.write(doc);
		writer.flush();
		writer.close();
		
	}
}









