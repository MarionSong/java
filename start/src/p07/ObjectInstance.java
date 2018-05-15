package p07;

public class ObjectInstance {
	public String toString() {
		return "дк"+getClass().getName();
	}
	public static void main(String[] args) {
		System.out.println(new ObjectInstance());
	}
}
