package p02;

import java.util.Scanner;

public class Pi {
	public static void main(String[] args) {
		final double PI=3.14;
		System.out.println("������Բ�İ뾶");
		double r=new Scanner(System.in).nextDouble();
		System.out.println("Բ���ܳ�Ϊ"+2*PI*r);
		int a=071;
		System.out.println(a);
		int b=0x90;
		System.out.println(b);
		int c=(int)(4.13*100);
		System.out.println(c);
		double d=3.14;
		System.out.println(Math.round(d));
		double e=0.1;
		double f=2.0-1.9;
		System.out.println(e==f);
		boolean bool=Math.abs(e-f)<(1e-6);
		System.out.println(bool);
		
	}
}
