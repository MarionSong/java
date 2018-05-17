package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpRequest {
	private String methon;
	private String uri;
	private String protocol;
	public HttpRequest(InputStream in) {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			String line=reader.readLine();
			if(line!=null&&line.length()>0) {
				String[] datas=line.split(" ");
				methon=datas[0];
				uri=datas[1];
				protocol=datas[2];
				if(uri.equals("/")) {
					uri="/index.html";
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getMethon() {
		return methon;
	}
	public void setMethon(String methon) {
		this.methon = methon;
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
	
	
}
