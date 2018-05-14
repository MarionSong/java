package p03;

import java.util.Scanner;

public class xuanze {

	public static void main(String[] args) {
		System.out.println("请输入要选择的数字");
		int a=new Scanner(System.in).nextInt();
		switch(a) {
		case 1:System.out.println("hehe");break;
		case 2:System.out.println("haha");break;
		default:System.out.println("aya");
		}
		int b=2;
		while(b<10) {
			b+=2;
			System.out.println(b);
		}
		int c=1;
		do {
			c+=2;
			System.out.println(c);
		}while(c<=20);
		for(int i=0;i<b;i++) {
			System.out.println(i);
		}
	}
	

}
