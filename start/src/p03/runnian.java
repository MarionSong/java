package p03;

import java.util.Scanner;

public class runnian {
	public static void main(String[] args) {
		System.out.println("���������");
		int year=new Scanner(System.in).nextInt();
		if((year%4==0&&year%100!=0)||year%400==0) {
			System.out.println("������");		
		}else
			System.out.println("��ƽ��");
	}
}
