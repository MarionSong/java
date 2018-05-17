package core;
/**
 * 这个类是核心类，用来起动服务器
 * @author song
 *
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {
	private ServerSocket server;
	private ExecutorService threadPool;
	public WebServer() {
		try {
			server=new ServerSocket(8888);
			threadPool=Executors.newFixedThreadPool(100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void start() {
		while(true) {
			try {
				Socket socket=server.accept();
				threadPool.execute(new ClientHandler(socket));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}	
	}
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
	
	
	
	
}
