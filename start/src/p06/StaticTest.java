package p06;

public class StaticTest {
	static String name;
	//��̬�����
	static {
		System.out.println(name + "��̬�����");
	}
	//�Ǿ�̬�����
	{
		System.out.println(name+"�Ǿ�̬�����");
	}

	public StaticTest(String a) {
		name = a;
		System.out.println(name + "���췽��");
	}

	public void method() {
		System.out.println(name + "��Ա����");
	}

	public static void main(String[] args) {
		StaticTest s1;// ������ʱ����Ѿ����о�̬�������
		StaticTest s2 = new StaticTest("s2");// new��ʱ��Ż����й��췽��
		StaticTest s3 = new StaticTest("s3");
		s3.method();//ֻ�е��õ�ʱ��Ż�����
	}
}