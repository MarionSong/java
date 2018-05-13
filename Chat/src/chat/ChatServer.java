package chat;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	List<TongXinThread> list=new ArrayList<>();
	public void start() {
		new Thread() {
			public void run() {
				startServer();
			}
		}.start();
	}
	protected void startServer() {
		try {
			ServerSocket ss=new ServerSocket(8000);
			while(true) {
				Socket s=ss.accept();
				handleSocket(s);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务停止");
		}
	}
	private void handleSocket(Socket s) {
		
		TongXinThread t=new TongXinThread(s);
		list.add(t);
		t.start();	
	}
	
	class TongXinThread extends Thread{
		private Socket s;
		private PrintWriter out;
		private BufferedReader in;
		private String name;
		public TongXinThread(Socket s) {
			this.s=s;
		}
		public void run() {
			try {
				this.out=new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
				this.in=new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
				this.name=in.readLine();
				sendToAll(name+"进入聊天室，在线人数"+list.size());
				String line=null;
				while(true) {
					line=in.readLine();
					if(line==null)break;
					sendToAll(name+"说 ："+line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			list.remove(this);
			sendToAll(name+"离开聊天室，在线人数"+list.size());
		}
		public void sendToAll(String msg) {
			System.out.println(msg);
			for (TongXinThread t : list) {
				t.send(msg);
			}
		}
		private void send(String msg) {
			out.println(msg);
			out.flush();
		}

	}
	
	
	public static void main(String[] args) {
		ChatServer server=new ChatServer();
		server.start();
		System.out.println("聊天室服务器");
	}
}
