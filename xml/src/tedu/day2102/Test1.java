package tedu.day2102;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Test1 {
	public static void main(String[] args) throws Exception{
		String path = 
		 Test1.class
		 .getResource("/books.xml")
		 .getPath();
		System.out.println(path);
		
		//数据处理器
		BookHandler h = new BookHandler();
		
		//解析文件
		SAXParserFactory
		.newInstance()//新建工厂
		.newSAXParser()//新建解析器
		.parse(path, h);//解析
		
		//取出数据处理器内部生成的集合
		List<Book> list = h.getList();
		for (Book b : list) {
			System.out.println(b);
		}
	}
}





