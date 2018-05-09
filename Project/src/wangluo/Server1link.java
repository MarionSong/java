package wangluo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class Server1link {
	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(6522);
		Socket so=server.accept();
		InputStream in=so.getInputStream();
		InputStreamReader isr=new InputStreamReader(in);
	
		int c;
		while((c=isr.read())!=-1) {
			System.out.println((char)c);
		}
		OutputStream out=so.getOutputStream();
		OutputStreamWriter osw=new OutputStreamWriter(out,"UTF-8");
		osw.write("您好,欢迎您的到来");
		osw.flush();
	}
}
