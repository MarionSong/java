package Mypackage2;

public class Outer {
	private int age;
	private String name;
	public void typeo() {
		System.out.println("�����ⲿ��");
		Inter i2=new Inter();
		i2.typei();
	}
	public void displays() {
		System.out.println("this is outer");
	}
	
	public class Inter{
		public String address;
		private int phonenum;
		
		public void typei() {
			System.out.println("�����ڲ���");
			phonenum=150;
			age=17;
		}
		
	}

}
