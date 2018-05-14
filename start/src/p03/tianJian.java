package p03;

import java.util.Scanner;

public class tianJian {
	public static void main(String[] args) {
//		System.out.println("请输入电话号");
//		int a=new Scanner(System.in).nextInt();
//		if(a!=110) {
//			System.out.println("您输入的号码不正确");
//		}else
//			System.out.println("ok");
		System.out.println("成绩");
		int a=new Scanner(System.in).nextInt();
		if(a<=100&&a>=90) {
			System.out.println("牛逼");
		}else if(a>=80&&a<90) {
			System.out.println("还可以");
		}else if(a>=0&&a<80) {
			System.out.println("重新考试");
		}else
			System.out.println("请输入正确的成绩");
	}
}
