package http;
/**
 * 这个类用来封装响应的信息
 * @author song
 *
 */

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import common.HttpContext;

public class HttpResponse {
	private String protocol;//响应遵循的协议
	private int status;//响应的状态码
	private String contentType;//响应的数据类型
	private int contentLength;//响应的数据长度
	private Map<Integer,String> DescMap=
			new HashMap<>();
	private OutputStream outputStream;
	public HttpResponse(OutputStream outputStream) {
		//初始化DescMap
		DescMap.put(HttpContext.CODE_OK, HttpContext.DESC_OK);
		DescMap.put(HttpContext.CODE_ERROR, HttpContext.DESC_ERROR);
		DescMap.put(HttpContext.CODE_NOTFOUND, HttpContext.DESC_NOTFOUND);
		this.outputStream=outputStream;
	}
	//保证响应头只被发送一次
	private boolean isSend;
	public OutputStream getOutputStream() {
		if(!isSend) {
			//提取响应码
			PrintStream ps=new PrintStream(outputStream);
			//拼接状态行
			ps.println(protocol+" "+status+" "+DescMap.get(status));
			//拼接响应头，响应的数据类型
			ps.println("Content-Type:"+contentType);
			//拼接响应头，响应的数据长度
			ps.println("Content-Length:"+contentLength);
			//格式规定，空白行
			ps.println();
			isSend=true;
		}
		return outputStream;	
	}
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getContentLength() {
		return contentLength;
	}
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
