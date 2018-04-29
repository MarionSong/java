package Mypackage2;

public class TestOuter {
	public static void main(String[] args) {
		Outer o=new Outer();
		Outer.Inter i=o.new Inter();
		Outer.Inter i1=new Outer().new Inter();
		o.typeo();
		
		
		
	}
}
