package p05;

import java.util.Date;

public class riqi {
	public static void main(String[] args) {
		Date date=new Date();
		String s1=String.format("%tY", date);
		String s2=String.format("%tM", date);
		System.out.println(s1);
		System.out.println(s2);
		String s3=String.format("%tc", date);
		System.out.println(s3);
		String s4=String.format("%tF", date);
		System.out.println(s4);
		
		
	}
}
