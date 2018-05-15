package p14;

import java.io.FileOutputStream;

public class Test3 {
	public static void main(String[] args) {
		try {
			FileOutputStream out=new FileOutputStream("C:\\Users\\song\\Desktop\\a.txt");
			String str="woshisheiwozaina";
			byte[] b=str.getBytes();
			out.write(b);
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
