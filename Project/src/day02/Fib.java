package day02;

import java.util.Scanner;

public class Fib {

	public static void main(String[] args) {
		System.out.println("求第几个斐波那契数列");
		int n=new Scanner(System.in).nextInt();
		long r=f(n);
		System.out.println(r);
	}

	private static long f(int n) {
		long f=0,g=1;
		while(n-->0) {
			g=g+f;
			f=g-f;
		}
		return g;
	}
}
