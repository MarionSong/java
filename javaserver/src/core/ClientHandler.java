package core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import http.HttpRequest;

public class ClientHandler implements Runnable {
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			HttpRequest request=new HttpRequest(socket.getInputStream());
			PrintStream ps=new PrintStream(socket.getOutputStream());
			ps.println("HTTP/1.1 200 OK");
			ps.println("Content-Type:text/html");
			File file=new File("WebContent"+request.getUri());
			ps.println();
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			byte[] bs=new byte[(int)file.length()];
			bis.read(bs);
			ps.write(bs);
			ps.flush();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
