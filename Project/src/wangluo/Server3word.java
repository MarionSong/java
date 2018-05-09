package wangluo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3word {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(8888);
		Socket so=ss.accept();
		BufferedReader br=new BufferedReader(new InputStreamReader(so.getInputStream()));
		BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\cgb1803\\Desktop\\123.txt"));
		String str=null;
		while((str=br.readLine())!=null) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		PrintWriter pw=new PrintWriter(so.getOutputStream(),true);
		pw.println("上传成功");
		br.close();
		bw.close();
		ss.close();
		so.close();
		
	}
}
