package extendspractice;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	int x2;
	int y2;
	public Line(int x,int y,int x2,int y2) {
		super(x,y,Color.RED);
		this.x2=x2;
		this.y2=y2;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x, y, x2, y2);
	}
	public void length(Graphics g) {
		int dx=x2-x;
		int dy=y2-y;
		double s=Math.sqrt(dx*dx+dy*dy);
		g.drawString("长度:"+s,125,270);
	}
	
}
