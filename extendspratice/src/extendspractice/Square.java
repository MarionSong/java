package extendspractice;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape{
	public Square(int x, int y) {
		super(x, y, Color.BLUE);
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, 250, 250);
	}
}
