package p07;

import java.util.Random;

public class Test2 {
	private static Random ran=new Random();
	private final int a1=ran.nextInt(10);
	private static final int a2=ran.nextInt(10);
	public static void main(String[] args) {
		Test2 t=new Test2();
		System.out.println(t.a1);
		System.out.println(t.a2);
		Test2 t1=new Test2();
		System.out.println(t1.a1);
		System.out.println(t1.a2);
	}
	
}
