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
					System.out.println(Thread.currentThread().getName()+"--Ʊ��"+num--);
				}else {
					System.out.println("Ʊ�Ѿ��۹�");
					return;
				}
			}
		}
	}
	public static void main(String[] args) {
		Ticket t=new Ticket();
		Thread a=new Thread(t,"�߳�1");
		Thread b=new Thread(t,"�߳�2");
		Thread c=new Thread(t,"�߳�3");
		Thread d=new Thread(t,"�߳�4");
		a.start();
		b.start();
		c.start();
		d.start();
	}
}
