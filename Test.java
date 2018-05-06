package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> l=new LinkedList<>();
		List<Integer> l1=new ArrayList<>();
		int i=0;
		Long start=System.currentTimeMillis();
		while (i<=10000){
			l.add(0,4);
			i++;
		}
		Long times=System.currentTimeMillis()-start;
		System.out.println("LinkedList 加10000次毫秒耗时："+times);
		i=0;
		start=System.currentTimeMillis();
		while (i<=10000){
			l1.add(0,4);
			i++;
		}
		times=System.currentTimeMillis()-start;
		System.out.println("ArrayList 加10000次毫秒耗时："+times);
		System.out.println(l.get(51));
		start=System.currentTimeMillis();
		removeEven(l);
		times=System.currentTimeMillis()-start;
		System.out.println("LinkedList输出操作："+times);
		start=System.currentTimeMillis();
		removeEven(l1);
		times=System.currentTimeMillis()-start;
		System.out.println("ArrayListList输出操作："+times);
		

	}
	public static void removeEven(List<Integer> lst) {
		Iterator<Integer> itr=lst.iterator();
		while(itr.hasNext()) {
			if(itr.next()%2==0)
				itr.remove();
		}
	}

}
