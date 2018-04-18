package Mypackage;

import java.util.Arrays;
import java.util.Random;

public class MergeArrays{

	public static void main(String[] args) {
		int[] a=arr();
		int[] b=arr();
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		merge(a,b);
	}
	private static int[] merge(int[] a, int[] b) {
		int[] arr=new int[] {};
		int i=0,j=0,k=0;
		while(i<a.length&&j<b.length) {
			if(a[i]>b[j]) {
				arr[k]=b[j];
				k++;
				j++;
			}
			else {
				arr[k]=a[i];
				i++;
				k++;
			}
		}
		while(i<a.length) {
			arr[k]=a[i];
			i++;
			k++;
		}
		while(j<b.length) {
			arr[k]=a[i];
			i++;
			k++;
		}
		return arr;
	}
	private static int[] arr() {
		int len=new Random().nextInt(6)+5;
		int[] ar=new int[len];
		for(int i=0;i<len;i++) {
			ar[i]=new Random().nextInt(100);
		}
		return ar;
	}

}
