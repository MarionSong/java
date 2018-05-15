package p06;

public class StaticVariable {
	static int x;// 静态变量
	int y;// 普通成员变量

	public StaticVariable(int x, int y) {// 构造函数
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {
		StaticVariable a = new StaticVariable(1, 2);
		StaticVariable b = new StaticVariable(13, 17);
		System.out.println("a.x的值是 = " + a.x);
		System.out.println("a.y的值是 = " + a.y);
		System.out.println("b.x的值是 = " + b.x);
		System.out.println("b.y的值是 = " + b.y);
	}
}