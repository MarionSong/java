package common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ��װ����������ز���
 * @author song
 *
 */
public class ServletContext {
	//�����ĸ���������ز���
	public static int port;//�˿ں�
	public static int maxThread;//�̳߳ش�С
	public static String protocol;//��ѭ��Э��
	public static String webRoot;//��Դ�ĸ�Ŀ¼
	public static String notFoundPage;//404ҳ��
	//�����Ӧ��������
	public static Map<String,String> map=new HashMap<>();
	static {
		init();//����xml�еĲ���
	}
	//������������ֵ
	private static void init() {
		try {
			SAXReader reader=new SAXReader();
			//����web.xml�ļ�
			File file=new File("config/web.xml");
			Document doc=reader.read(file);
			//��ʼ��ȡ�ļ�
			Element rootElement = doc.getRootElement();
			Element serviceEle = rootElement.element("service");
			Element connEle = serviceEle.element("connector");
			//��ȡ���Ե�ֵ
			port = Integer.valueOf(connEle.attributeValue("port"));			
			maxThread = Integer.valueOf(connEle.attributeValue("maxThread"));			
			protocol = connEle.attributeValue("protocol");		
			webRoot = serviceEle.elementText("webroot");
			//��ȡ404��Ϣ
			notFoundPage=serviceEle.elementText("not-found-page");
			/*
			 * ��ʼ��typeMap
			 * �����Ҫ������Դʱ�����ݺ�׺����map��ȡ����Ӧ��type
			 */
			List<Element> types=rootElement.element("type-mappings").elements();
			for (Element element : types) {
				String key=element.attributeValue("ext");
				String value=element.attributeValue("type");
				map.put(key, value);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
