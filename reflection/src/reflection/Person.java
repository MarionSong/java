package reflection;

public class Person {
	private int age;
	private String name;
	public Person(String name,int age) {
		this.age=age;
		this.name=name;
		System.out.println("---------");
	}
	public void foo(String string) {
		System.out.println(string);
	}
	public void say() {
		System.out.println("say");
	}
}
