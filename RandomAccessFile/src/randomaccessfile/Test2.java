package randomaccessfile;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf =
		  new RandomAccessFile(
		  "d:/abc/f3", "rw");
		
		//����������read()������
		//read()�������ļ���һ�����ݣ�
		//������������
		
		//������ȡ��׼��ʽ
		byte[] buff = new byte[5];
		int n;//ÿһ��������
		while((n = raf.read(buff)) != -1) {
			System.out.println(
			 n+": "+Arrays.toString(buff));   
		}
		
		raf.close();
		
	}
}




