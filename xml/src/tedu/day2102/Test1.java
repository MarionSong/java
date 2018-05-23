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
		
		//���ݴ�����
		BookHandler h = new BookHandler();
		
		//�����ļ�
		SAXParserFactory
		.newInstance()//�½�����
		.newSAXParser()//�½�������
		.parse(path, h);//����
		
		//ȡ�����ݴ������ڲ����ɵļ���
		List<Book> list = h.getList();
		for (Book b : list) {
			System.out.println(b);
		}
	}
}





