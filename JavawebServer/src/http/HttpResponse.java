package http;
/**
 * �����������װ��Ӧ����Ϣ
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
	private String protocol;//��Ӧ��ѭ��Э��
	private int status;//��Ӧ��״̬��
	private String contentType;//��Ӧ����������
	private int contentLength;//��Ӧ�����ݳ���
	private Map<Integer,String> DescMap=
			new HashMap<>();
	private OutputStream outputStream;
	public HttpResponse(OutputStream outputStream) {
		//��ʼ��DescMap
		DescMap.put(HttpContext.CODE_OK, HttpContext.DESC_OK);
		DescMap.put(HttpContext.CODE_ERROR, HttpContext.DESC_ERROR);
		DescMap.put(HttpContext.CODE_NOTFOUND, HttpContext.DESC_NOTFOUND);
		this.outputStream=outputStream;
	}
	//��֤��Ӧͷֻ������һ��
	private boolean isSend;
	public OutputStream getOutputStream() {
		if(!isSend) {
			//��ȡ��Ӧ��
			PrintStream ps=new PrintStream(outputStream);
			//ƴ��״̬��
			ps.println(protocol+" "+status+" "+DescMap.get(status));
			//ƴ����Ӧͷ����Ӧ����������
			ps.println("Content-Type:"+contentType);
			//ƴ����Ӧͷ����Ӧ�����ݳ���
			ps.println("Content-Length:"+contentLength);
			//��ʽ�涨���հ���
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
