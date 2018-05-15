package p11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("dazihao");
		List<?> list1=new LinkedList<Integer>();
		List<?> list2=list;
		System.out.println(list.get(0));
		list.set(0, "hehe");
		System.out.println(list2.get(0));
		
		
	}
}
