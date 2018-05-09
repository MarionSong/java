package wangluo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2uper {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(8888);
		Socket socket=ss.accept();
		String ip=socket.getInetAddress().getHostAddress();//获取ip，明确是谁进来了
		System.out.println("ip :"+ip);
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
		String line=null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
			pw.println(line.toUpperCase());
		}
		socket.close();
		ss.close();
		
	}
}
