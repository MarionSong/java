package 配置文件;


import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class xmlDemo {
	@Test
	public void readXml() throws Exception {
		//创建saxReader对象
		SAXReader reader=new SAXReader();
		//读取xml文件
		Document doc=reader.read(new File("src/NewFile.xml"));
		//获取 根元素
		Element node=doc.getRootElement();
		System.out.println(node.getName());
		Iterator<Element> it=node.elementIterator();
		while(it.hasNext()) {
			Element e=it.next();//获取子元素
			Attribute att=e.attribute("id");
			String id=att.getValue();
//			System.out.println(att.getValue());
			Element name=e.element("name");
			String n=name.getText();
//			System.out.println(name.getText());
			Element price=e.element("price");
			String p=price.getText();
//			System.out.println(price.getText());
			Element pages=e.element("pages");
			String pa=pages.getText();
			Element author=e.element("author");
			String au=author.getText();
			Book book=new Book();
			book.setId(Integer.parseInt(id));
			book.setAuthor(au);
			book.setName(n);
			book.setPage(Integer.parseInt(pa));
			book.setPrice(Integer.parseInt(p));
			System.out.println(book);
		}
	}
}
