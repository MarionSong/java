package p02;

public class fuhaoYunsuan {
	public static void main(String[] args) {
		int a=~123;
		System.out.println(a);
		System.out.println(2&3);
		System.out.println(3|4);
		System.out.println(2^10);
		System.out.println("2>3与4!=7的与结果：" + (2 > 3 & 4 != 7));
		int b=-256;
		System.out.println(b>>2);
		int c=-256;
		System.out.println(c>>>2);
		byte d=(byte)(-32>>>1);
		System.out.println(d);
	}
}
