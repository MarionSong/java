package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * �����������װhttp����������Ϣ
 * @author song
 *
 */
public class HttpRequest {
	//�����������
	private String method;//����ʽ
	private String uri;//�������Դ·��
	private String protocol;//��ѭ��Э��
	//����paramMap����������ŵ�ַ���л�ȡ���û������ֵ
	private Map<String,String> paramMap=new HashMap<>();
	//�ڹ��캯���г�ʼ���������
	public HttpRequest(InputStream in) {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			//��ȡ�����е���Ϣ
			String line=reader.readLine();
			System.out.println(line);
			if(line!=null&&line.length()>0) {
				String[] datas=line.split(" ");
				method=datas[0];//��װ����ʽ
				uri=datas[1];//��װ����·��
				protocol=datas[2];//��װЭ����
				//����վ����Ĭ����ҳ
				if(uri.equals("/")) {
					uri="/index.html";
				}
				//��ʼ��paramMap,�������·��uri
				if(uri!=null&&uri.contains("?")) {
					//ֻȡuri·���ĺ�벿�ֺ���username��password
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
	//����keyȥ����value
	public String getParam(String key) {
		String value=paramMap.get(key);
		return value;
	}
	
}
