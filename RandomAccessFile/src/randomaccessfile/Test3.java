package randomaccessfile;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Test3 {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = 
		new RandomAccessFile(
		"d:/abc/a.bmp", "rw");
		
		//����18
		raf.seek(18);
		
		//�����Ⱥ͸߶Ƚ���ı���
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
		 * ���±�54λ��
		 * ��ȡÿ����ɫֵ����ɫ����д���ļ�
		 */
		raf.seek(54);
		
		//int b;//����ÿ�ζ�ȡ���ֽ�ֵ
		//while((b = raf.read()) != -1) {
		//	b = ~b;//�ֽ�ֵ��
		//	//�±궨λ��ǰһ��λ��
		//	raf.seek(raf.getFilePointer()-1);
		//	raf.write(b);//�ֽ�ֵд���ļ�
		//}
		
		// 8k - 8192
		byte[] buff = new byte[8192];
		int n;//ÿһ��������
		while((n = raf.read(buff)) != -1) {
			//���������е�ǰn���ֽ�
			for (int i = 0; i < n; i++) {
				buff[i] = (byte)(~buff[i]);
			}
			//�±�����Ųnλ
			raf.seek(raf.getFilePointer()-n);
			//������ǰn��������д���ļ�
			raf.write(buff,0,n);
		}
		
		raf.close();
	}
}






