package tedu.day2101;

public class Test1 {
	public static void main(String[] args) {
		SingletonA a1 = SingletonA.getInstance();
		SingletonA a2 = SingletonA.getInstance();
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a1 == a2);
		
		SingletonB b1 = SingletonB.getInstance();
		SingletonB b2 = SingletonB.getInstance();    
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1 == b2);
		
		SingletonC c1 = SingletonC.getInstance();
		SingletonC c2 = SingletonC.getInstance();  
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1 == c2);
		
	}
}
