package ����;

import java.util.ArrayList;
/**
 * �����������ʮ����ת���ɶ�����
 */
import java.util.Scanner;

public class Demo001 {
	public static void main(String[] args) {
		System.out.println("������һ��ʮ��������");
		int a=new Scanner(System.in).nextInt();
		transform(a);
	}

	private static void transform(int a) {
		StringBuilder sb=new StringBuilder();
		if(a>=0) {
			while(true) {
				String b=String.valueOf(a%2);
				sb.append(b);
				a/=2;
				if(a==0) {
					break;
				}
			}
			System.out.println(sb.reverse().toString());
		}else {
			int c=-a;
			while(true) {
				sb.append(String.valueOf(c%2));
				c/=2;
				if(c==0) {
					break;
				}
			}
			sb.append(1);
			System.out.println(sb.reverse().toString());
			/*ArrayList<String> arr=new ArrayList<>();
			while(true) {
				arr.add(String.valueOf(c%2));
				c/=2;
				if(c==0) {
					break;
				}
			}
			arr.add(String.valueOf(1));
			String str=String.join("", arr);*/
		}
	}
}
