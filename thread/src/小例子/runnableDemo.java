package 小例子;

public class runnableDemo {
	public static void main(String[] args) {
		
		TestThread3 t = new TestThread3();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		
	}
}
class TestThread3 implements Runnable{
	String str="";
	int ticket=200;
	@Override
	public void run() {
		while(true) {
			synchronized(this) {
				if(ticket<=0) {
					break;
				}
				System.out.println(Thread.currentThread().getName()+"卖出了"+ticket--);

			}
		}
	}

	
	
}