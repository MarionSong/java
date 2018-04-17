package day0402;

import java.util.Arrays;
import java.util.Random;

public class sort {

	public static void main(String[] args) {
		int[] arr=arrays();
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		int temp;
		for(int i=1;i<arr.length;i++) {
			temp=arr[i];
			while(i>=1&&arr[i-1]>temp) {
				arr[i]=arr[i-1];
				i--;
			}
			arr[i]=temp;
		}
	}

	private static int[] arrays() {
		int len=new Random().nextInt(6)+5;
		int[] ar=new int[len];
		for(int i=0;i<len;i++) {
			ar[i]=new Random().nextInt(100);
		}
		return ar;
	}

}
