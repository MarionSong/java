package tedu.day2102;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test3 {
	public static void main(String[] args) throws Exception {
		/*
		 *  /
		 *   |- books
		 *        |- book
		 *            |- @isbn
		 *            |- name
		 *            |- authros
		 *                 |- author
		 *                 |- author
		 *            |- publisher
		 *            |- pages
		 *            |- price
		 *        |- book
		 *        ...
		 */
		String path = 
		 Test1.class
		 .getResource("/books.xml")
		 .getPath();
		System.out.println(path);
		
		List<Element> list = 
		 new SAXReader().read(path)
		 .getRootElement().elements("book");
		
		List<Book> books = new ArrayList<>();   
		
		for (Element e : list) {
			Book b = new Book();
			books.add(b);
			b.setIsbn(e.attributeValue("isbn"));
			b.setName(e.elementText("name"));
			b.setPublisher(e.elementText("publisher"));
			b.setPages(e.elementText("pages"));
			b.setPrice(e.elementText("price"));
			List<Element> authors = 
			 e.element("authros").elements();
			for (Element a : authors) {
				b.getAuthors().add(a.getText());
			}
		}
		
		
		for (Book b : books) {
			System.out.println(b);
		}
		
		
		
		
	}
}



