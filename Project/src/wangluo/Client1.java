package wangluo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws Exception {
		Socket soket=new Socket("127.0.0.1",6522);
		OutputStreamWriter os=new OutputStreamWriter(soket.getOutputStream(),"UTF-8");
		os.write("我是谁");
		os.flush();
		
		InputStream in=soket.getInputStream();
		InputStreamReader isr=new InputStreamReader(in);
		int c;
		while((c=isr.read())!=-1) {
			System.out.println((char)c);
		}
		soket.close();
		
	}
}
