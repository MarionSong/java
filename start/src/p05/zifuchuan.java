package p05;

public class zifuchuan {
	public static void main(String[] args) {
		String str="12a3456asdaf ";
		int i=str.indexOf("a");
		System.out.println(i);
		int i1=str.indexOf("a",i+1);
		System.out.println(i1);
		int i2=str.lastIndexOf("a");
		System.out.println(i2);
		int i3=str.lastIndexOf("a",5);
		System.out.println(i3);
		if(str.startsWith("12")) {
			System.out.println("hehe");
		}else
			System.out.println("oo");
		System.out.println(str.endsWith("daf"));
		char[] a=str.toCharArray();
		System.out.println(a);
		System.out.println(str.contains("a"));
		System.out.println(str.substring(3));
		System.out.println(str.substring(3,5));
		System.out.println(str.replaceAll("a", "*"));
		System.out.println(str.replaceFirst("a", "hee"));
		String[] str1=str.split("a");
		for(int i11=0;i11<str1.length;i11++) {
			System.out.println(str1[i11]);
		}
		System.out.println(str.toUpperCase());
		System.out.println(str.trim());
		
		
		
	}
}
