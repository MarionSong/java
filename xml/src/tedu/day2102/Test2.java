package tedu.day2102;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Test2 {
	public static void main(String[] args) throws Exception {
		String path = 
		 Test2.class
		 .getResource("/email.xml")
		 .getPath();
		
		System.out.println(path);
		
		//读取xml，生成DOM树，
		//并得到树根对象
		Document doc = 
		 new SAXReader().read(path);
		System.out.println(doc);
	
		//打印整棵树的数据
		
		//xml的根元素
		Element email = doc.getRootElement();
		print(email);
		
		System.out.println("------------------------------");
		//
		f1(email);
		f2(email);
		f3(email);
		f4(email);
		f5(email);
		f6(email);
	}

	private static void f1(Element email) {
		Element body = email.element("body");
		System.out.println(body.getText());
	}

	private static void f2(Element email) {
		List<Element> list = 
		 email.element("to")
		      .elements("to-email");
		
		for (Element e : list) {
			System.out.println(e.getText());
		}
	}

	private static void f3(Element email) {
		String s =
			email.elementText("from");
		System.out.println(s);
	}

	private static void f4(Element email) {
		Element subject = 
		 (Element) 
		 email.selectSingleNode("/email/subject");
		System.out.println(subject.getText());
		
	}

	private static void f5(Element email) {
		List<Element> list = 
		 email.selectNodes("to/to-email");
		
		for (Element e : list) {
			System.out.println(e.getText()); 
		}
	}

	private static void f6(Element email) {
		String d = email.valueOf("@date");
		String t = email.valueOf("@time");
		String body = email.valueOf("body");
		System.out.println(d);
		System.out.println(t);
		System.out.println(body);
	}

	private static void print(Element e) {
		//遍历元素属性
		for(int i=0;i<e.attributeCount();i++) {
			//取出其中一个属性对象
			Attribute attr = e.attribute(i);
			String n = attr.getName();
			String v = attr.getValue();
			System.out.println(n+"="+v);
		}
		//是否只含文本
		if(e.isTextOnly()) {
			System.out.println(e.getText());
			return;
		}	
		
		//获得元素e的所有子元素
		List<Element> list = e.elements();
		for (Element ele : list) {
			print(ele);
		}
	}
}





