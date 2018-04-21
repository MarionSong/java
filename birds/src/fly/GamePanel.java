package fly;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public GamePanel() {
		setPreferredSize(new Dimension(432, 644));
	}
	int x1=0, y1=0;
	int x2=432, y2=0;
	int x3=100, y3=-350;
	int x4=100+255, y4=-400;
	int x5=0, y5=498;
	int x6=70, y6=200;
	//定义帧的计数变量
	static int counter=0;
	public void paint(Graphics g) {
		g.drawLine(10,10,200,100);
		g.drawRect(50,20,160,120);
		g.drawOval(55,25,150,110);
		g.drawImage(FlappyBird.bgImg,0,0,null);
		g.drawImage(FlappyBird.columnImg,100,-350,null);
		g.drawImage(FlappyBird.columnImg,100+255,-400,null);
		g.drawImage(FlappyBird.groundImg,0,498,null);
		g.drawImage(FlappyBird.birdImg,70,200,null);
		
		
	}
	public void action() throws Exception{
		while(true) {
			counter++;
			bgMove();
			columnMove();
			groundMove();
			birdMove();
			repaint();
			Thread.sleep(1000/60);
		}
	}
	
}
