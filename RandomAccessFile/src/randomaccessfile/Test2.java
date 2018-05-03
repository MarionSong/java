package randomaccessfile;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf =
		  new RandomAccessFile(
		  "d:/abc/f3", "rw");
		
		//容器，交给read()方法，
		//read()方法从文件读一批数据，
		//放入数组容器
		
		//批量读取标准格式
		byte[] buff = new byte[5];
		int n;//每一批的数量
		while((n = raf.read(buff)) != -1) {
			System.out.println(
			 n+": "+Arrays.toString(buff));   
		}
		
		raf.close();
		
	}
}




