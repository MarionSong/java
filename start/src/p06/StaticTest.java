package p06;

public class StaticTest {
	static String name;
	//静态代码块
	static {
		System.out.println(name + "静态代码块");
	}
	//非静态代码块
	{
		System.out.println(name+"非静态代码块");
	}

	public StaticTest(String a) {
		name = a;
		System.out.println(name + "构造方法");
	}

	public void method() {
		System.out.println(name + "成员方法");
	}

	public static void main(String[] args) {
		StaticTest s1;// 声明的时候就已经运行静态代码块了
		StaticTest s2 = new StaticTest("s2");// new的时候才会运行构造方法
		StaticTest s3 = new StaticTest("s3");
		s3.method();//只有调用的时候才会运行
	}
}