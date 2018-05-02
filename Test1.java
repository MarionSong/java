package ADT;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] arr=new int[] {1,2,3,4,5,6};
		int[] newarr=new int[arr.length*2];
		for(int i=0;i<arr.length;i++)
			newarr[i]=arr[i];
		arr=newarr;
		System.out.println(Arrays.toString(arr));
	}
}
