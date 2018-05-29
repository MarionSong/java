package аЁР§зг;

public class die {
	public static void main(String[] args) {
		TestThread4 t=new TestThread4();
		new Thread(t).start();
		try {
			Thread.sleep(10);
		}catch (Exception e) {
			// TODO: handle exception
		}
		t.flag=true;
		new Thread(t).start();
	}
}
class TestThread4 implements Runnable{
	boolean flag=false;
	String A=new String("");
	String B=new String("");
	
	@Override
	public void run() {
		System.out.println(A==B);
		if(false) {
			while(true) {
				synchronized (A) {
					try {
						Thread.sleep(100);
					}catch (Exception e) {
						// TODO: handle exception
					}
					synchronized (B) {}
				}
				System.out.println("AA...running");
			}
		}else {
			while(true) {
				synchronized(B) {
					try {
						Thread.sleep(100);
					}catch (Exception e) {
						// TODO: handle exception
					}
					synchronized (A) {
						
					}
				}
				System.out.println("BB..running");
			}
		}
		
		
		
		
	}
	
}