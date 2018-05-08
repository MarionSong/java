package thread;

public class Ticket implements Runnable{
	int num=100;
	public void run() {
		while(true) {
			synchronized(this) {
				if(num>0) {
					try {
						Thread.sleep(100);
					}catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"--票数"+num--);
				}else {
					System.out.println("票已经售光");
					return;
				}
			}
		}
	}
	public static void main(String[] args) {
		Ticket t=new Ticket();
		Thread a=new Thread(t,"线程1");
		Thread b=new Thread(t,"线程2");
		Thread c=new Thread(t,"线程3");
		Thread d=new Thread(t,"线程4");
		a.start();
		b.start();
		c.start();
		d.start();
	}
}
