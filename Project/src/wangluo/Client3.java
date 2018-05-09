package wangluo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client3 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket so=new Socket("127.0.0.1",8888);
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\cgb1803\\Desktop\\111\\111.txt"));
		PrintWriter pw=new PrintWriter(so.getOutputStream(),true);
		String str=null;
		while((str=br.readLine())!=null) {
			pw.println(str);
		}
		so.shutdownOutput();
		BufferedReader br1=new BufferedReader(new InputStreamReader(so.getInputStream()));
		String str1=br1.readLine();
		System.out.println(str1);
		br.close();
		so.close();
		
		
		
		
	}
}
