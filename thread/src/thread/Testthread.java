package thread;

public class Testthread {
	public static void main(String[] args) {
		
		Th test1=new Th();
		Th test2=new Th();
		test1.start();
		test2.start();
	}
	static class Th extends Thread{
		int a;		
		@Override
		public void run() {
			for(a=10;a<33;a++) {
				System.out.println(currentThread().getName()+a);
			}
		}
	}
}
