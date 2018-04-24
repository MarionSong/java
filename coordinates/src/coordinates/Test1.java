package coordinates;

public class Test1 {
	public static void main(String[] args) {
		Point p1=new Point(3,4);
		Point p2=new Point(9,2);
		Point3D p3=new Point3D(3,4,5);
		Point3D p4=new Point3D(9,2,8);
		System.out.println(p1.toString());
		System.out.println(p3.toString());
		System.out.println(p1.distance());
		System.out.println(p3.distance());
		System.out.println(p1.distance(p2)); 
		System.out.println(p1.distance(p3));
		System.out.println(p3.distance(p2));
		System.out.println(p3.distance(p4));
	
	}
}
