package Mypackage;

import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		System.out.println("请输入一个整数：");
		int x=new Scanner(System.in).nextInt();
		System.out.println("请再输入一个整数：");
		int y=new Scanner(System.in).nextInt();
		int a=divisor(x,y);
		int b=min(x,y);
		System.out.println(x+"和"+y+"的最大公约数是"+a);
		System.out.println(x+"和"+y+"的最小公倍数是"+b);
	}
	public static int divisor(int x,int y) {
		int temp;
		if(y>x) {
			temp=x;
			x=y;
			y=temp;
		}
		return max(x,y);
	}
	public static int max(int x, int y) {
		if(x%y==0)
			return y;
		else {
			return max(y,x%y);
		}
	}

	public static int min(int x, int y) {
		return (x*y)/divisor(x,y);
	}

}
