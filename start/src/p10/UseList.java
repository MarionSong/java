package p10;

import java.util.ArrayList;
import java.util.List;

public class UseList {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
