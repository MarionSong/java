package Mypackage;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		System.out.println("请输入循环次数:");
		int n=new Scanner(System.in).nextInt();
		double sum=1;
		int a=-1;
		for(int i=1;i<n;i++) {
			sum+=a*(1.0/(2*i+1));
			a*=-1;
		}
		System.out.println(4*sum);
	}

}
