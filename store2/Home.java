package store2;

import java.util.ArrayList;
import java.util.Scanner;

public class Home {

	public static void main(String[] args) {
		ArrayList<Goods> list=new ArrayList<>();
		addStore(list);
		while(true) {
			int choose=chooseFunction();
			switch(choose) {
			case 1:printStore(list);break;
			case 2:update(list);break;
			case 3:exit();return;
			default:System.out.println("�����������������");break;
			}
		}

	}
	private static void update(ArrayList<Goods> list) {
		System.out.println("�޸���Ʒ����");
		System.out.println("------------------------");
		for(int i=0;i<list.size();i++) {
			Goods g=list.get(i);
			System.out.println("��������Ʒ����");
			g.count=new Scanner(System.in).nextInt();
			list.set(i,g);
		}
		
	}
	private static void printStore(ArrayList<Goods> list) {
		int totalCount=0;
		double totalPrice=0;
		System.out.println("-----------------------");
		System.out.println("��Ʒ����	�۸�	����");
		for(int i=0;i<list.size();i++) {
			Goods a=list.get(i);
			System.out.println(a.name+"	"+a.price+"	"+ a.count);
			totalCount+=a.count;
			totalPrice+=a.price*a.count;		
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("�ܿ������"+totalCount); 
		System.out.println("�����Ʒ�ܽ�"+totalPrice);
	}
		
	
	public static void exit(){
		System.out.println("----------------�˳�---------------");
		System.out.println("�����˳�ϵͳ");
	}	
	public static int chooseFunction() {
		System.out.println("-------------������------------");
		System.out.println("1.�鿴����嵥");
		System.out.println("2.�޸���Ʒ�������");
		System.out.println("3.�˳�");
		System.out.println("������Ҫִ�еĲ�����ţ�");
		//���ռ�������Ĺ���ѡ�����
		int choose = new Scanner(System.in).nextInt();
		return choose;
	}

	public static void addStore(ArrayList<Goods> list) {
		for(int i=0;i<4;i++) {
			Goods g=new Goods();
			System.out.println("��������Ʒ��");
			g.name=new Scanner(System.in).nextLine();
			list.add(g);
			System.out.println("��������Ʒ�۸�");
			g.price=new Scanner(System.in).nextDouble();
			list.add(g);
			System.out.println("��������Ʒ����");
			g.count=new Scanner(System.in).nextInt();
			list.add(g);
		}
		
	}

}
