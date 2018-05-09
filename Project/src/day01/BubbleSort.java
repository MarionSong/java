package day01;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a=arr();
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	private static int[] arr() {
		int len=new Random().nextInt(6)+5;
		int[] ar=new int[len];
		for(int i=0;i<len;i++) {
			ar[i]=new Random().nextInt(100);
		}
		return ar;
	}

	private static void sort(int[] a) {
		int temp;
		int isChange;
		for(int i=0;i<a.length-1;i++) {
			isChange=0;
			for(int j=0;j<a.length-1-i;j++) {
				if(a[j]>a[j+1]) {
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					isChange=1;
				}
				
			}
			if(isChange==0)
				break;
		}
		
	}

}



