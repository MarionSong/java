package Mypackage;

import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		System.out.println("������һ��������");
		int x=new Scanner(System.in).nextInt();
		System.out.println("��������һ��������");
		int y=new Scanner(System.in).nextInt();
		int a=divisor(x,y);
		int b=min(x,y);
		System.out.println(x+"��"+y+"�����Լ����"+a);
		System.out.println(x+"��"+y+"����С��������"+b);
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
