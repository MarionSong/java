package p06;

public class StaticVariable {
	static int x;// ��̬����
	int y;// ��ͨ��Ա����

	public StaticVariable(int x, int y) {// ���캯��
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {
		StaticVariable a = new StaticVariable(1, 2);
		StaticVariable b = new StaticVariable(13, 17);
		System.out.println("a.x��ֵ�� = " + a.x);
		System.out.println("a.y��ֵ�� = " + a.y);
		System.out.println("b.x��ֵ�� = " + b.x);
		System.out.println("b.y��ֵ�� = " + b.y);
	}
}