package algorithm;

import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) {
		Demo01 sum=new Demo01();
		Scanner scan=new Scanner(System.in);
		System.out.println("Please input a number:");
		int a=scan.nextInt();
		System.out.println("result:"+sum.f(a));
	}

	private static int f(int x) {
		if(x==0)
			return 0;
		else 
			return 2*f(x-1)+x*x;
		
	}

}
