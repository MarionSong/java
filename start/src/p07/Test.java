package p07;

final class Test {
	static int a=3;
	void doit() {
		a++;
	}
	public static void main(String[] args) {
		Test t=new Test();
		t.a++;
		System.out.println(a);
		t.doit();
		System.out.println(a);
	}
}
