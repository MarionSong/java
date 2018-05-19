package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个类用来封装http请求的相关信息
 * @author song
 *
 */
public class HttpRequest {
	//声明请求参数
	private String method;//请求方式
	private String uri;//请求的资源路径
	private String protocol;//遵循的协议
	//声明paramMap对象，用来存放地址栏中获取的用户输入的值
	private Map<String,String> paramMap=new HashMap<>();
	//在构造函数中初始化请求参数
	public HttpRequest(InputStream in) {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			//获取请求行的信息
			String line=reader.readLine();
			System.out.println(line);
			if(line!=null&&line.length()>0) {
				String[] datas=line.split(" ");
				method=datas[0];//封装请求方式
				uri=datas[1];//封装请求路径
				protocol=datas[2];//封装协议名
				//给网站设置默认主页
				if(uri.equals("/")) {
					uri="/index.html";
				}
				//初始化paramMap,拆分请求路径uri
				if(uri!=null&&uri.contains("?")) {
					//只取uri路径的后半部分含有username和password
					String str=uri.split("\\?")[1];
					String[] str1=str.split("&");
					for (String string : str1) {
						String key=string.split("=")[0];
						String value=string.split("=")[1];
						paramMap.put(key, value);					
					}
				}	
			}			
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	//根据key去调用value
	public String getParam(String key) {
		String value=paramMap.get(key);
		return value;
	}
	
}
