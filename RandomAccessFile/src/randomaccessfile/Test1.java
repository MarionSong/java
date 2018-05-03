package randomaccessfile;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Test1 {
	public static void main(String[] args) throws Exception {
		/*
		 * abc
		 * 97   98   99
		 * 61   62   63
		 */
		
		//文件不存在，会自动新建
		//目录不存在，出现异常
		RandomAccessFile raf = 
		 new RandomAccessFile("d:/abc/f3", "rw");
		
		raf.write(97);//00 00 00 61 --> 61
		raf.write(98);
		raf.write(99);
		raf.write(356);//00 00 01 64 --> 64
		/////////////////////
		byte[] buff = {
				101,102,103,104,105,
				106,107,108,109,110
		};
		raf.write(buff);//全部10个
		raf.write(buff,3,4);//3开始的4个
		
		//System.out.println(raf.getFilePointer());
		//System.out.println(raf.read());
		
		raf.seek(0);//下标定位到0位置
		
		//单字节读取的标准格式
		int b;
		while((b = raf.read()) != -1) {
			System.out.println(b);
		}
		
		raf.close();//释放系统资源

	}
}








