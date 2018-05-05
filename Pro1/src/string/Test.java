package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String s="woshisongming123213";
		String b="woshisongming";
		String a="1141262721";
		String d="ÎÒ²Ý,¹þ¹þ";
		System.out.println(s.charAt(3));
		System.out.println(s.length());
		System.out.println(s.equals(b));
		System.out.println(s.hashCode());
		System.out.println(b.hashCode());
		System.out.println(s.indexOf('s'));
		System.out.println(s.substring(4));
		System.out.println(a.charAt(3));
		int c=88;
		System.out.println(String.valueOf(c));
		StringBuilder sb=new StringBuilder("abc");
		sb.append("hehehe");
		System.out.println(sb);
		if(a.matches("\\d{10,14}")) {
			System.out.println("ok");
		}
		d=d.replaceAll("²Ý", "*");
		System.out.println(d);
		String[] e=d.split(",");
		for(int i=0;i<e.length;i++) {
			String f=e[i];
			System.out.println(f);
		}
		Matcher m=Pattern.compile("\\d").matcher(s);
		while(m.find()) {
			String i=m.group();
			System.out.println(i);
		}
	}
	
}
