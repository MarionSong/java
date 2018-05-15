package p08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		int age=Integer.parseInt("200");
		System.out.println(age);
		Integer in=Integer.valueOf(200);
		System.out.println(in.equals(age));
		System.out.println(Math.log10(22));
		Date d=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sd.format(d));
	}
}
