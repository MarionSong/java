package tedu.day2101;
//更好的懒汉式
public class SingletonB {	
	private SingletonB() {
	}	
	public static SingletonB getInstance() {
		//第一次用到Inner类时，才创建SingletonB
		return Inner.s;
	}
	
	//静态内部类的静态成员
	private static class Inner {
		static SingletonB s; // = new SingletonB();
		static {
			//...
			//...
			s = new SingletonB();
		}
	}
	
}


