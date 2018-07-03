package bt;

public class Main {
	public static void main(String[] args) {
		Node a=new Node(Integer.valueOf(1));
		Node b=new Node(Integer.valueOf(2));
		Node c=new Node(Integer.valueOf(3));
		a.left=b;
		a.right=c;
	}
}
