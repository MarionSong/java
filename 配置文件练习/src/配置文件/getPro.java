package ≈‰÷√Œƒº˛;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class getPro {
	public static void main(String[] args) {
		try {
			Properties pro=new Properties();
			File file=new File("shuxing.properties");
			pro.load(new FileInputStream(file));
			String str1=pro.getProperty("username");
			String str2=pro.getProperty("password");
			System.out.println(str1+":"+str2);
		}catch (Exception e) {
			// TODO: handle exception
		}


	}
}
