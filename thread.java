package thread.test;

public class ThreadTest
{
    public static void main(String[] args)
    {
        TreadTest1 thread1 = new TreadTest1();
        TreadTest2 thread2 = new TreadTest2();

        thread1.start();
        thread2.start();
    }

}
class TreadTest1 extends Thread{
    public void run() {
        for (int i = 0; i < 1000; ++i)
        {
            System.out.println("Test1 " + i);
        }
    }
}
class TreadTest2 extends Thread{
    public void run() {
        for (int i = 0; i < 1000; ++i)
        {
            System.out.println("Test2 " + i);
        }
    }
}
