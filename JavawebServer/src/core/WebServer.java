package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.ServletContext;

/**
 * 这个类是核心类，用来启动服务器
 * @author song
 *
 */

public class WebServer {  
	//声明ServerSocket，代表服务器端
	private ServerSocket server;
	//声明线程池
	private ExecutorService threadPool;
	//在构造函数中初始化
	public WebServer() {
		try {
			server=new ServerSocket(ServletContext.port);
			//初始化线程池，线程数量在ServletContext中获取
			threadPool=Executors.newFixedThreadPool(ServletContext.maxThread);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start() {
		try {
			while(true) {
				//接收客户端信息
				Socket socket=server.accept();
				threadPool.execute(new ClientHandler(socket));
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	//启动服务
	public static void main(String[] args) {
		WebServer server=new WebServer();
		server.start();
	}
	
	
	
	
	
}
