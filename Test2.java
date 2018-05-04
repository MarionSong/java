package splitfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("ԭ�ļ���");
		String s = new Scanner(System.in).nextLine();
		File file = new File(s);
		if(! file.isFile()) {
			System.out.println("�ļ�����ȷ");
			return;
		}
		System.out.print("��ִ�С(Kb)��");
		long size = 
		 new Scanner(System.in).nextLong();
		size *= 1024; // Kb������ֽ�
		
		try {
			split(file, size);
			System.out.println("���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ʧ��");
		}
		
	}

	
	
	
	private static void split(
			File file, long size) throws Exception {
		//����ļ���
		String name = file.getName();
		//׼����Ų���ļ���Ŀ¼
		File dir = zhunBeiMuLu(file);
		//System.out.println(dir.getAbsolutePath());
		
		BufferedInputStream in = 
		 new BufferedInputStream(
		 new FileInputStream(file));
		BufferedOutputStream out = null;
		long byteCount = 0;//�ֽڼ���
		int fileCount = 0;//�ļ�����
		
		//���ֽڶ�ȡ
		int b;
		while((b = in.read()) != -1) {
			//���������
			//1.û�������  2.����
			if(out==null || byteCount==size) {
				if(byteCount==size) out.close();//�ر�ǰһ�������
				out =
				 new BufferedOutputStream(					
				 new FileOutputStream(
				 new File(dir, name+"."+(++fileCount))));				
				byteCount=0;//�����ֽڼ���
			}
			
			out.write(b);
			byteCount++;
		}
		
		in.close();
		out.close();//�ر����һ�������
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	private static File zhunBeiMuLu(File file) {
		/*
		 * "d:/abc/a.zip"
		 * "d:/abc/a.zip_split"
		 * �����ڣ��½�
		 * ���ڣ����
		 */
		File dir = new File(
			file.getAbsoluteFile()+"_split");
		if(dir.exists()) {//����
			clear(dir);
		} else {
			dir.mkdirs();
		}
		return dir;
	}

	private static void clear(File dir) {
		File[] files = dir.listFiles();
		//���ܻ���б�ֱ�ӽ���
		if(files == null) return;
		
		//���dirĿ¼�ڲ������ļ�
		for (File f : files) {
			if(f.isFile()) {//f���ļ�
				f.delete();
			} else {//f��Ŀ¼
				clear(f);//���
				f.delete();//ɾ��
			}
		}
	}
}




