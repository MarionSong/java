package wangluo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Uptask implements Runnable{
	Socket so;
	public Uptask(Socket so) {
		this.so=so;
	}
	@Override
	public void run() {
		int count =1;
		try {
			String ip=so.getInetAddress().getHostName();
			System.out.println("ip:"+ip+"....connect");
			InputStream in=so.getInputStream();
			File dir=new File("D:\\javapractice\\新建文件夹");
			if(!(dir.exists())) dir.mkdir();
			File file=new File(dir,ip+"jpg");
			while(file.exists()) {
				file=new File(dir,ip+"("+(count++)+").jpg");
			}
			FileOutputStream fo=new FileOutputStream(file);
			byte[] buff=new byte[8192];
			int len=0;
			while((len=in.read(buff))!=-1) {
				fo.write(buff,0,len);
			}
			OutputStream out  = so.getOutputStream();  
            out.write("上传成功".getBytes());  
			out.flush();
			fo.close();
			so.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();			
		}	
	}

}
