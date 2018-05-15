package p14;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		File file=new File("C:\\Users\\song\\Desktop\\a.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("文件创建成功");
			}catch (Exception e) {
				System.out.println("文件创建失败");
			}
		}
		String name=file.getName();
		System.out.println(name);
		String path=file.getAbsolutePath();
		System.out.println(path);
		System.out.println(file.getPath());
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd/hh-mm-ss");
		String time=sim.format(date);
		System.out.println(time);
		
		
		
		
		
	}
}
