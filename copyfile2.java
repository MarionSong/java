package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class copyfile2 {
	public static void main(String[] args)throws IOException {
		copy_file();
	}

	private static void copy_file() throws IOException {
		System.out.println("请输入你要复制的文件");
		String s1=new Scanner(System.in).nextLine();
		System.out.println("请输入您要复制到的位置");
		String s2=new Scanner(System.in).nextLine();
		InputStreamReader in=new InputStreamReader(new FileInputStream(s1));
		OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream(s2),"UTF-8");
		char[] c=new char[10];
		int i;
		while((i=in.read(c))!=-1) {
			out.write(c,0,i);
			out.flush();
		}
		in.close();
		out.close();
		
		
		
	}
}
