package p07;
import org.junit.Test;

public class Test3 {
	public int x=2;
	public class tt{
		public int x=9;
		@Test
		public void doit(int x) {
			x++;
			this.x++;
			System.out.println(x);
			System.out.println(this.x);
			System.out.println(Test3.this.x++);
		}
	}
	public static void main(String[] args) {
		Test3.tt a=new Test3().new tt();
		a.doit(11);
		
	}
}
