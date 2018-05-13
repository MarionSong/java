package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ChatClient {
	private BufferedReader in;
	private PrintWriter out;
	private LinkedList<String> list=new LinkedList<>();
	private Thread prtThread;
	private boolean inputFlag=false;
	private Socket s;
	public void start() {
		try {
			this.s=new Socket("127.0.0.1",8000);
			this.in=new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
			this.out=new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
			System.out.println("请输入昵称");
			String name=new Scanner(System.in).nextLine();
			out.println(name);
			out.flush();
			new Thread() {public void run() {
				input();
			}}.start();
			new Thread() {public void run() {
				receive();
			}}.start();
			new Thread() {public void run() {
				print();
			}}.start();		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("无法连接服务器");
		}
	}
	
	
	
	private void input() {
		while(s.isConnected()) {
			new Scanner(System.in).nextLine();
			inputFlag=true;
			String str=new Scanner(System.in).nextLine();
			out.println(str);
			out.flush();
			inputFlag=false;
			synchronized (list) {
				list.notifyAll();
			}
		}	
	}
	
	protected void receive() {
		try {
			String line;
			while((line=in.readLine())!=null) {
				list.offer(line);
				list.notifyAll();
			}
		}catch (Exception e) {

		}
		System.out.println("断开连接");
	}
	protected void print() {
		while(true) {
			synchronized (list) {
				while(list.isEmpty()||inputFlag) {
					try {
						list.wait();
					}catch (Exception e) {
						
					}
				}
				String s=list.poll();
				System.out.println(s);
			}
		}
		
	}

	public static void main(String[] args) {
		ChatClient client =new ChatClient();
		client.start();
	}
}
