package p03;

import java.util.Arrays;

public class shuzu {
	public static void main(String[] args) {
		int[] a= {1,2,3,4};
		int[] b=new int[] {2,3,4,5,6};
		for (int i : b) {
			System.out.println(i);
		}
		System.out.println("---------");
		for(int i=0;i<20;i++) {
			if(i%2==0) {
				System.out.println(i);
				
			}
		}
		System.out.println("---------");
		for(int i=0;i<20;i++) {
			if(i%2!=0) {
				continue;
			}
			System.out.println(i);
		}
	}
}
