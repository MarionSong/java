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
			default:System.out.println("输入错误，请重新输入");break;
			}
		}

	}
	private static void update(ArrayList<Goods> list) {
		System.out.println("修改商品数量");
		System.out.println("------------------------");
		for(int i=0;i<list.size();i++) {
			Goods g=list.get(i);
			System.out.println("请输入商品数量");
			g.count=new Scanner(System.in).nextInt();
			list.set(i,g);
		}
		
	}
	private static void printStore(ArrayList<Goods> list) {
		int totalCount=0;
		double totalPrice=0;
		System.out.println("-----------------------");
		System.out.println("商品名称	价格	数量");
		for(int i=0;i<list.size();i++) {
			Goods a=list.get(i);
			System.out.println(a.name+"	"+a.price+"	"+ a.count);
			totalCount+=a.count;
			totalPrice+=a.price*a.count;		
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("总库存数："+totalCount); 
		System.out.println("库存商品总金额："+totalPrice);
	}
		
	
	public static void exit(){
		System.out.println("----------------退出---------------");
		System.out.println("您已退出系统");
	}	
	public static int chooseFunction() {
		System.out.println("-------------库存管理------------");
		System.out.println("1.查看库存清单");
		System.out.println("2.修改商品库存数量");
		System.out.println("3.退出");
		System.out.println("请输入要执行的操作序号：");
		//接收键盘输入的功能选项序号
		int choose = new Scanner(System.in).nextInt();
		return choose;
	}

	public static void addStore(ArrayList<Goods> list) {
		for(int i=0;i<4;i++) {
			Goods g=new Goods();
			System.out.println("请输入商品名");
			g.name=new Scanner(System.in).nextLine();
			list.add(g);
			System.out.println("请输入商品价格");
			g.price=new Scanner(System.in).nextDouble();
			list.add(g);
			System.out.println("请输入商品数量");
			g.count=new Scanner(System.in).nextInt();
			list.add(g);
		}
		
	}

}
