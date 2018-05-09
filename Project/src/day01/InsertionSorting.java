package day01;

import java.util.Arrays;
import java.util.Random;

public class InsertionSorting {

	public static void main(String[] args) {
		int[] a=s();
		System.out.println(Arrays.toString(a));
		System.out.println("============");
		sort(a);
		System.out.println("============");
		System.out.println(Arrays.toString(a));
	}
	private static int[] s() {
		//产生随机长度的数组保存len,比如5+[0,6)
		//新建长度len长度的数组保存到变量a
		//遍历数组a随机填入100内的随机值
		//返回数组a的内存地址
		int len=5+(new Random().nextInt(6));
		int[] a=new int[len];
		for(int i=0;i<len;i++) {
			a[i]=new Random().nextInt(100);
		}
		return a;
	}
	private static void sort(int[] a) {
		int temp;
		for(int i=1;i<a.length;i++) {
			temp=a[i];
			while(i>=1&&a[i-1]>temp) {
				a[i]=a[i-1];
				i--;
			}
			a[i]=temp;
		}
	}
}
