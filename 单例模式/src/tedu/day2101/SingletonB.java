package tedu.day2101;
//���õ�����ʽ
public class SingletonB {	
	private SingletonB() {
	}	
	public static SingletonB getInstance() {
		//��һ���õ�Inner��ʱ���Ŵ���SingletonB
		return Inner.s;
	}
	
	//��̬�ڲ���ľ�̬��Ա
	private static class Inner {
		static SingletonB s; // = new SingletonB();
		static {
			//...
			//...
			s = new SingletonB();
		}
	}
	
}


