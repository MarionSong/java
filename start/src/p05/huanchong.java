package p05;

public class huanchong {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("�Ұ���");
		sb.append("����Ů���Ѱ�");
		System.out.println(sb.toString());
		sb.setCharAt(1,'ϲ');
		System.out.println(sb);
		sb.insert(2, "��");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.delete(1, 3);
		System.out.println(sb);
		sb.toString();
		
	}
}
