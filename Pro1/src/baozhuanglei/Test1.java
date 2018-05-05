package baozhuanglei;

import java.text.DecimalFormat;

public class Test1 {
	public static void main(String[] args) {
		Integer i=Integer.valueOf(1111);//Integer i=1111;自动装箱
		System.out.println(i);
		int j=i.intValue();//int j=i;自动拆箱
		System.out.println(j);
		String k="123123";
		System.out.println(Integer.parseInt(k));
		Integer a=10;
		a=Integer.valueOf(a.intValue()-1);
		System.out.println(a);
		double d1=123.4456788;
		System.out.println(new DecimalFormat("000.00").format(d1));
		
	}
}
