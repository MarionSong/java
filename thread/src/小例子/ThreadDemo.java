package С����;
/**
 * �������������ϰThread
 * @author song
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		new TestThread().start();
		while(true) {
			System.out.println("main:"+Thread.currentThread().
					getName()+"is Runnning");
		}
	}
	
}
class TestThread extends Thread{
	//�̳�Thread��дrun����
	public void run() {
		while(true) {
			System.out.println("TestThread:"+
		Thread.currentThread().getName()+"is Running");
		}
	}
	
}