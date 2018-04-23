package extendspractice;

import javax.swing.JFrame;

public class Test1 {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setTitle("绘图");
		JFrame.setDefaultLookAndFeelDecorated(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		DrawPanel p=new DrawPanel();
		f.add(p);
		f.pack();
		f.setVisible(true);
		
		
	}
}
