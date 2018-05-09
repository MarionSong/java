package day02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		int[] a=arr();
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("查找的目标值:");
		int t=new Scanner(System.in).nextInt();
		int index=binarySearch(a,t);
		if(index>=0) 
			System.out.println(t+"在"+index+"位置");
		else
			System.out.println("找不到目标值"+t);
		
	}
		private static int[] arr() {
			int len=new Random().nextInt(6)+5;
			int[] ar=new int[len];
			for(int i=0;i<len;i++) {
				ar[i]=new Random().nextInt(100);
			}
			return ar;
	}
	private static int binarySearch(int[] a, int t) {
		int lo=0,hi=a.length-1,mid = 0;
		while(lo<=hi) {
			mid=(lo+hi)/2;
			if(t==a[mid])
				return mid;
			else if(a[mid]>t) 
				hi=mid-1;
			else 
				lo=mid+1;
		}
		return -1;
		
	}

}
