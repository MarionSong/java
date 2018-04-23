package extendspractice;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	Shape s;
	/*
	 * 状态码status
	 * 0.初始状态
	 * 1 表示绘制图形
	 * 2 表示清空
	 */
	int status;
	
	public DrawPanel() {
		
		//面版的期望大小
		setPreferredSize(new Dimension(500,500));
		//添加监听器
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(status!=1) { 
					status=1;//绘制图形
					switch(new Random().nextInt(4)) {
					case 0:JOptionPane.showMessageDialog(DrawPanel.this, "不能新建抽象类实例");status=0;return;
					case 1:s=new Line(125,250,375,250);break; 
					case 2:s=new Circle(125,125);break;
					case 3:s=new Square(125,125);break;
					}
				}else
					status=2;
				//刷新画面
				repaint();
			}
		});
	}
	@Override
	public void paint(Graphics g) {
		//0.初始状态
		//1.绘制图形
		//2.清空
		if(status==0) {
			//空
		}else if(status==1) {
			s.draw(g);
			if(s instanceof Line) {
				Line line=(Line) s;
				line.length(g);
			}
		}else if(status==2) {
			s.clear(g);
		}
		
	}
	
	
	
	
	
	
}
