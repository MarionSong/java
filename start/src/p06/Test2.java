package p06;

public class Test2 {
	public static void main(String[] args) {
		Test2 t=new Test2();
		int a=t.add(10,20,30);
		System.out.println(a);
	}

	private int add(int...x) {
		int rus=0;
		for(int i=0;i<x.length;i++) {
			rus+=x[i];
		}
		return rus;
	}
}
