package tedu.day2102;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookHandler extends DefaultHandler {
	private List<Book> list = new ArrayList<>();
	private StringBuilder text = new StringBuilder();
	private Book book;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("book".equals(qName)) {
			book = new Book();
			list.add(book);
			book.setIsbn(attributes.getValue(0));
		}
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String s = text.toString().trim();
		if(s.length() != 0) {
			//这里处理完整文本
			if("name".equals(qName)) {
				book.setName(s);
			} else if("author".equals(qName)) {
				book.getAuthors().add(s);
			} else if("publisher".equals(qName)) {
				book.setPublisher(s);
			} else if("pages".equals(qName)) {
				book.setPages(s);
			} else if("price".equals(qName)) {
				book.setPrice(s);
			} 
		}
		text.delete(0, text.length());
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch,start,length);
	}

	public List<Book> getList() {
		return list;
	}
	
}



