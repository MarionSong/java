package tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
public class Bullet {
	BufferedImage img=Main.bullet;
	int x;
	int y;
	//int stepPx=new Random().nextInt(10)+1;
	//int stepPy=new Random().nextInt(10);
	int stepPy=10;
	public void step() {
		y-=stepPy;
		//x-=stepPx;
		
		
	}
	public void paint(Graphics g) {
		g.drawImage(img,x,y,null);
	}
	public boolean isOut() {
		return y<=-img.getHeight();
	}
}