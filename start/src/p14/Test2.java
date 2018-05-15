package p14;

import java.io.File;

public class Test2 {
	public static void main(String[] args) {
		File file=new File("c:\\");
		File[] files=file.listFiles();
		for (File file2 : files) {
			if(file2.isDirectory()) {
				System.out.println(file2.getName());
			}
			
		}
		
		
		
	}
}
