package day02;

import java.util.Scanner;

public class Tower {

	public static void main(String[] args) {
		System.out.println("几层汉诺塔");
		int n=new Scanner(System.in).nextInt();
		f(n,"A","B","C");
	}

	private static void f(int n, String c1, String c2, String c3) {
		if(n==1) {
			System.out.println(c1+"->"+c3);
			return;
		}
		f(n-1,c1,c3,c2);
		System.out.println(c1+"->"+c3);
		f(n-1,c2,c1,c3);
	}

}
