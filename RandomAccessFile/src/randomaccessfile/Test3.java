package randomaccessfile;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Test3 {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = 
		new RandomAccessFile(
		"d:/abc/a.bmp", "rw");
		
		//跳到18
		raf.seek(18);
		
		//保存宽度和高度结果的变量
		int w = 0;
		int h = 0;
		
		w |= raf.read()<<0;
		w |= raf.read()<<8;
		w |= raf.read()<<16;
		w |= raf.read()<<24;
		
		h |= raf.read()<<0;
		h |= raf.read()<<8;
		h |= raf.read()<<16;
		h |= raf.read()<<24;
		
		System.out.println(w);
		System.out.println(h);
		
		/*
		 * 从下标54位置
		 * 读取每个颜色值，求反色，再写回文件
		 */
		raf.seek(54);
		
		//int b;//保存每次读取的字节值
		//while((b = raf.read()) != -1) {
		//	b = ~b;//字节值求反
		//	//下标定位到前一个位置
		//	raf.seek(raf.getFilePointer()-1);
		//	raf.write(b);//字节值写回文件
		//}
		
		// 8k - 8192
		byte[] buff = new byte[8192];
		int n;//每一批的数量
		while((n = raf.read(buff)) != -1) {
			//处理数组中的前n个字节
			for (int i = 0; i < n; i++) {
				buff[i] = (byte)(~buff[i]);
			}
			//下标往回挪n位
			raf.seek(raf.getFilePointer()-n);
			//数组中前n个，批量写回文件
			raf.write(buff,0,n);
		}
		
		raf.close();
	}
}






