package С����;
/**
 * �����ǰ̨�̣߳��û��̣߳���
 * ��̨�̣߳��ػ��̣߳�������
 * @author song
 *
 */
public class userThread {
	public static void main(String[] args) {
		TestThread1 t = new TestThread1();
		TestThread1 t1 = new TestThread1();
		t.setDaemon(true);
		t.start();
		t1.start();
		
	}
}
class TestThread1 extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("TestThread:"+Thread.currentThread()
			.getName()+"is running");
		}
	}
	
}