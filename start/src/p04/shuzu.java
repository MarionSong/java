package p04;

import java.util.Arrays;

public class shuzu {
	public static void main(String[] args) {
		char[] a= {'a','b','c'};
		System.out.println(a);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		char[][] b=new char[4][];
		b[0]=new char[] { '��', '��', '��', '��', '��' };
		b[1] = new char[] { '��', '��', '��', '��', '��' };
		b[2] = new char[] { 'ҹ', '��', '��', '��', '��' };
		b[3] = new char[] { '��', '��', '֪', '��', '��' };
		for(int i=0;i<5;i++) {
			for(int j=3;j>=0;j--) {
				System.out.print(b[j][i]);
			}
			System.out.println();
		}
		int[] c=new int[] {1,2,3,4,5,6,7,8};
		//Arrays.fill(c,9);
		for(int i:c) {
			System.out.println(i);
		}
		int[] d=Arrays.copyOf(c, 20);
		int[] e=new int[20] ;
		System.arraycopy(c, 2, e, 10, 4);
		int[] f=Arrays.copyOfRange(c, 3, 6);
	}
}
