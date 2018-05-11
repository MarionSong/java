package tedu.day2101;
//懒汉式
public class SingletonA {
	private static SingletonA s;
	
	//私有构造方法
	private SingletonA() {
	}
	
	//新建，或获取对象
	public static SingletonA getInstance() {
		//A
		//B
		if(s == null) {
			//A
			//B
			synchronized (SingletonA.class) {    
				if(s == null) {
					s = new SingletonA();
				}
			}
		}
		
		return s;
	}
}


