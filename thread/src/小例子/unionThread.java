package 小例子;
/**
 * 联合线程的例子
 * @author song
 *
 */
public class unionThread {
	public static void main(String[] args) {
		Thread t=new TestThread1();
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("main:"+Thread.currentThread()
			.getName()+"is running");
			if(i==5) {
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
