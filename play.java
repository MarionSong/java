package day0402;

import java.util.Arrays;
import java.util.Random;

public class play {

	public static void main(String[] args) {
		int[] redball=init(33);
		int[] blueball=init(16);
		System.out.println(Arrays.toString(redball));
		System.out.println(Arrays.toString(blueball));
		int[] redresult=red(redball);
		int blueresult=blue(blueball);
		System.out.println(Arrays.toString(redresult));
		System.out.println(blueresult);
	}

	private static int[] red(int[] redball) {
		int[] x=new int[6];
		boolean[] y=new boolean[33];
		for(int i=0;i<6;i++) {
			int j;
			do {
				j=new Random().nextInt(33);
			}while(y[j]);
			x[i]=redball[j];
			y[j]=true;
		}
		return x;
	}

	private static int blue(int[] blueball) {
		int a=new Random().nextInt(16);
		return a;
	}

	private static int[] init(int n) {
		int[] a=new int[n];
		for(int i=1;i<=n;i++) {
			a[i-1]=i;
		}
		return a;
	}

}
