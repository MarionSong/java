package 小例子;
/**
 * 这个例子用来练习Thread
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
	//继承Thread重写run方法
	public void run() {
		while(true) {
			System.out.println("TestThread:"+
		Thread.currentThread().getName()+"is Running");
		}
	}
	
}