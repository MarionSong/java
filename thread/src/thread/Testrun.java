package thread;

public class Testrun {
	public static void main(String[] args) {
		RR r=new RR();
		Thread t1=new Thread(r,"A");
		Thread t2=new Thread(r,"B");
		t1.start();
		t2.start();
	}
	static class RR implements Runnable{
	
		@Override
		public void run() {
			for(int a=10;a<33;a++) {
				System.out.println(Thread.currentThread().getName()+a);
			}
			
		}
		
	}
}
