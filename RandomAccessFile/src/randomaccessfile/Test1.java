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
		
		//�ļ������ڣ����Զ��½�
		//Ŀ¼�����ڣ������쳣
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
		raf.write(buff);//ȫ��10��
		raf.write(buff,3,4);//3��ʼ��4��
		
		//System.out.println(raf.getFilePointer());
		//System.out.println(raf.read());
		
		raf.seek(0);//�±궨λ��0λ��
		
		//���ֽڶ�ȡ�ı�׼��ʽ
		int b;
		while((b = raf.read()) != -1) {
			System.out.println(b);
		}
		
		raf.close();//�ͷ�ϵͳ��Դ

	}
}








