package studentname2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CallName {
	public static void main(String[] args) {
		ArrayList<Student> list=new ArrayList<>();
		addStudent(list);
		printStudent(list);
		randomStudent(list);
	}

	private static void randomStudent(ArrayList<Student> list) {
		int a=new Random().nextInt(list.size());
		Student s=list.get(a);
		System.out.println("被随机点名的同学："+s.getName() + "，年龄:" + s.getAge());
		
	}

	public static void printStudent(ArrayList<Student> list) {
		for(int i=0;i<list.size();i++) {
			Student s=list.get(i);
			System.out.println("姓名："+s.getName() +",年龄："+s.getAge());
		}
		
	}

	public static void addStudent(ArrayList<Student> list) {
		for(int i=0;i<3;i++) {
			Student s=new Student();
			System.out.println("请输入第"+i+"个同学姓名");
			s.setName(new Scanner(System.in).nextLine());
			System.out.println("请输入第"+i+"个同学年龄");
			s.setAge(new Scanner(System.in).nextInt());
			list.add(s);
			
		}
		
	}
}
