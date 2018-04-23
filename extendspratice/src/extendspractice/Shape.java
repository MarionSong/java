package extendspractice;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	int x;
	int y;
	Color color;
	public Shape(int x,int y,Color color) {
		this.x=x;
		this.y=y;
		this.color=color;
	}
	//泛指的图形父类中，无法实现 定义成通用的抽象方法
	public abstract void draw(Graphics g);
	public void clear(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,500,500);//(0,0)点，500*500宽度
		
	}
}
