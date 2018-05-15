package p11;

public class EnumIndex {
	enum Constants{
		red,black,write
	}
	public static void main(String[] args) {
		for(int i=0;i<Constants.values().length;i++) {
			System.out.println(Constants.values()[i]);
		}
	}
}
