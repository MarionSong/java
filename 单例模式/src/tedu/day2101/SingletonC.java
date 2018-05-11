package tedu.day2101;
//����ʽ
public class SingletonC {
	private static SingletonC s;// = new SingletonC();
	static {
		s = new SingletonC();
	}
	
	private SingletonC() {
	}
	
	public static SingletonC getInstance() {
		return s;
	}
}
