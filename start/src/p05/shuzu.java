package p05;

public class shuzu {
	public static void main(String[] args) {
		char[] a= {'Œ“','∞Æ','—ß','œ∞'};
		String s=new String(a);
		System.out.println(s);
		String s1=new String(a,0,2);
		System.out.println(s1);
		String s2=s+s1;
		System.out.println(s2);
		char ch=s2.charAt(3);
		System.out.println(ch);
		
	}
}
