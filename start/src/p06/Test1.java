package p06;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		Test1 t=new Test1();
		int[] i= {0,10,22};
		for (int j : i) {
			System.out.println(j);
		}
		t.change(i);
		System.out.println(Arrays.toString(i));
	}

	private void change(int[] i) {
		i[0]=100;
		
	}
}
