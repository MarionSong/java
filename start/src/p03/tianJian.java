package p03;

import java.util.Scanner;

public class tianJian {
	public static void main(String[] args) {
//		System.out.println("������绰��");
//		int a=new Scanner(System.in).nextInt();
//		if(a!=110) {
//			System.out.println("������ĺ��벻��ȷ");
//		}else
//			System.out.println("ok");
		System.out.println("�ɼ�");
		int a=new Scanner(System.in).nextInt();
		if(a<=100&&a>=90) {
			System.out.println("ţ��");
		}else if(a>=80&&a<90) {
			System.out.println("������");
		}else if(a>=0&&a<80) {
			System.out.println("���¿���");
		}else
			System.out.println("��������ȷ�ĳɼ�");
	}
}
