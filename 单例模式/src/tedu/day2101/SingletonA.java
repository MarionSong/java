package tedu.day2101;
//����ʽ
public class SingletonA {
	private static SingletonA s;
	
	//˽�й��췽��
	private SingletonA() {
	}
	
	//�½������ȡ����
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


