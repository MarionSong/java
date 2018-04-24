package coordinates;

public class Point3D extends Point{
	private int z;
	public Point3D(int x, int y,int z) {
		super(x, y);
		this.z=z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return "("+getX()+","+getY()+","+z+")";
	}
	public double distance() {
		int x=getX();
		int y=getY();
		return Math.sqrt(x*x+y*y+z*z);
	}
	public double distance(Point p) {
		int dx=getX()-p.getX();
		int dy=getY()-p.getY();
		//假设参数是二维点,z是0
		int dz=z-0;
		if(p instanceof Point3D) {
			Point3D p3d=(Point3D)p;
			dz=z-p3d.z;
		}
		return Math.sqrt(dx*dx+dy*dy+dz*dz);
	}
}
