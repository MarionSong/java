package common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 封装服务器的相关参数
 * @author song
 *
 */
public class ServletContext {
	//声明四个服务器相关参数
	public static int port;//端口号
	public static int maxThread;//线程池大小
	public static String protocol;//遵循的协议
	public static String webRoot;//资源的根目录
	public static String notFoundPage;//404页面
	//存放响应数据类型
	public static Map<String,String> map=new HashMap<>();
	static {
		init();//解析xml中的参数
	}
	//解析参数并赋值
	private static void init() {
		try {
			SAXReader reader=new SAXReader();
			//加载web.xml文件
			File file=new File("config/web.xml");
			Document doc=reader.read(file);
			//开始读取文件
			Element rootElement = doc.getRootElement();
			Element serviceEle = rootElement.element("service");
			Element connEle = serviceEle.element("connector");
			//获取属性的值
			port = Integer.valueOf(connEle.attributeValue("port"));			
			maxThread = Integer.valueOf(connEle.attributeValue("maxThread"));			
			protocol = connEle.attributeValue("protocol");		
			webRoot = serviceEle.elementText("webroot");
			//读取404信息
			notFoundPage=serviceEle.elementText("not-found-page");
			/*
			 * 初始化typeMap
			 * 浏览器要访问资源时，根据后缀名从map中取出响应的type
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
