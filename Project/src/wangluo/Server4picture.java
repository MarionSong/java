package wangluo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4picture {
	private static ServerSocket ss;
	public static void main(String[] args) throws IOException {
		Upfile();
	}
	private static void Upfile() throws IOException {
		ss=new ServerSocket(8989);
		while(true) {
			Socket so=ss.accept();
			new Thread(new Uptask(so)).start();;
		}
		
		
		
	}
}
