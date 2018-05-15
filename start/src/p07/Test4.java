package p07;
interface Out{
	
}
public class Test4 {
	public Out doit(final String a) {
		class In implements Out{
			In(String s){
				s=a;
				System.out.println(s);
			}
		}
		return new In("neibu");
	}
	public static void main(String[] args) {
		Test4 aa = new Test4();
		aa.doit("waibu");
		
	}
}
