package randomaccessfile;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		System.out.println("�����ļ���");
		String s = new Scanner(System.in).nextLine();
		File file = new File(s);
		if(! file.isFile()) {//����Ĳ����ļ�
			System.out.println("�����ļ�����");
			return;
		}
		//key���������
		System.out.print("Key��");
		int key = new Scanner(System.in).nextInt();
		try {
			encript(file, key);
			System.out.println("���");
		} catch (Exception e) {
			System.out.println("ʧ��");
		}
	}

	private static void encript(
			File file,
			int key) throws Exception {
		
		RandomAccessFile raf = 
		 new RandomAccessFile(file, "rw");
		
		byte[] buff = new byte[8192];
		int n;//ÿһ��������
		while((n = raf.read(buff)) != -1) {
			//��������ǰn���ֽڼ��ܡ�����
			for (int i = 0; i < n; i++) {
				buff[i] ^= key;
			}
			//�±���ǰ�ƶ�nλ
			raf.seek(raf.getFilePointer()-n);   
			//����ǰn����һ��д���ļ�
			raf.write(buff, 0, n);
		}
		
		raf.close();
	}
}





