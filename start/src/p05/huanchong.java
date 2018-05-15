package p05;

public class huanchong {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("我爱你");
		sb.append("做我女朋友吧");
		System.out.println(sb.toString());
		sb.setCharAt(1,'喜');
		System.out.println(sb);
		sb.insert(2, "欢");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.delete(1, 3);
		System.out.println(sb);
		sb.toString();
		
	}
}
