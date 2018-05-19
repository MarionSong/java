package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import common.ServletContext;

/**
 * ������Ǻ����࣬��������������
 * @author song
 *
 */

public class WebServer {  
	//����ServerSocket�������������
	private ServerSocket server;
	//�����̳߳�
	private ExecutorService threadPool;
	//�ڹ��캯���г�ʼ��
	public WebServer() {
		try {
			server=new ServerSocket(ServletContext.port);
			//��ʼ���̳߳أ��߳�������ServletContext�л�ȡ
			threadPool=Executors.newFixedThreadPool(ServletContext.maxThread);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start() {
		try {
			while(true) {
				//���տͻ�����Ϣ
				Socket socket=server.accept();
				threadPool.execute(new ClientHandler(socket));
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	//��������
	public static void main(String[] args) {
		WebServer server=new WebServer();
		server.start();
	}
	
	
	
	
	
}
