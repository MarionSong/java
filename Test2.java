package splitfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("原文件：");
		String s = new Scanner(System.in).nextLine();
		File file = new File(s);
		if(! file.isFile()) {
			System.out.println("文件不正确");
			return;
		}
		System.out.print("拆分大小(Kb)：");
		long size = 
		 new Scanner(System.in).nextLong();
		size *= 1024; // Kb换算成字节
		
		try {
			split(file, size);
			System.out.println("完成");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败");
		}
		
	}

	
	
	
	private static void split(
			File file, long size) throws Exception {
		//获得文件名
		String name = file.getName();
		//准备存放拆分文件的目录
		File dir = zhunBeiMuLu(file);
		//System.out.println(dir.getAbsolutePath());
		
		BufferedInputStream in = 
		 new BufferedInputStream(
		 new FileInputStream(file));
		BufferedOutputStream out = null;
		long byteCount = 0;//字节计数
		int fileCount = 0;//文件计数
		
		//单字节读取
		int b;
		while((b = in.read()) != -1) {
			//创建输出流
			//1.没有输出流  2.满了
			if(out==null || byteCount==size) {
				if(byteCount==size) out.close();//关闭前一个输出流
				out =
				 new BufferedOutputStream(					
				 new FileOutputStream(
				 new File(dir, name+"."+(++fileCount))));				
				byteCount=0;//重置字节计数
			}
			
			out.write(b);
			byteCount++;
		}
		
		in.close();
		out.close();//关闭最后一个输出流
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	private static File zhunBeiMuLu(File file) {
		/*
		 * "d:/abc/a.zip"
		 * "d:/abc/a.zip_split"
		 * 不存在，新建
		 * 存在，清空
		 */
		File dir = new File(
			file.getAbsoluteFile()+"_split");
		if(dir.exists()) {//存在
			clear(dir);
		} else {
			dir.mkdirs();
		}
		return dir;
	}

	private static void clear(File dir) {
		File[] files = dir.listFiles();
		//不能获得列表，直接结束
		if(files == null) return;
		
		//清空dir目录内部所有文件
		for (File f : files) {
			if(f.isFile()) {//f是文件
				f.delete();
			} else {//f是目录
				clear(f);//清空
				f.delete();//删除
			}
		}
	}
}




