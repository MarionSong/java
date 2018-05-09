package wangluo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client4 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",8989);
		System.out.println("请输入要上传的文件位置");
		String f=new Scanner(System.in).nextLine();
		FileInputStream fi=new FileInputStream(f);
		OutputStream out=socket.getOutputStream();
		byte[] buff=new byte[8192];
		int len=0;
		while((fi.read(buff))!=-1) {
			out.write(buff,0,len);
		}
		socket.shutdownOutput();  
        
        InputStream in = socket.getInputStream();  
        byte[] buf2 = new byte[1024];  
        int len2 = in.read(buf2);  
        String result = new String(buf2,0,len2);  
        System.out.println(result);  
        socket.close();  
        fi.close(); 
	}
}
