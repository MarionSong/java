package wangluo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket so=new Socket("127.0.0.1",8888);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(so.getOutputStream(),true);
		BufferedReader br2=new BufferedReader(new InputStreamReader(so.getInputStream()));
		String line=null;
		while((line=br.readLine())!=null) {
			if("over".equals(line)) break;
			pw.println(line);
			String str=br2.readLine();
			System.out.println("up:"+str);
		}
		so.close();
		
		
	}
}
