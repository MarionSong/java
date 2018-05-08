package thread;

import java.awt.Container;
import java.net.URL;

import javax.swing.*;


public class SwingAndThread extends JFrame {
	private JLabel jl=new JLabel();
	private static Thread t;
	private int count=0;
	private Container container=getContentPane();
	public SwingAndThread() {
		setBounds(300,200,250,100);
		container.setLayout(null);
		try {
			URL url=SwingAndThread.class.getResource("1.gif");
			Icon icon=new ImageIcon(url);
			jl.setIcon(icon);
		}catch (Exception e) {
			System.out.println("图片不存在，请将1.gif复制到当前目录下");
			return;
		}
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		jl.setBounds(10, 10, 200, 50);
		jl.setOpaque(true);
		t=new Thread(new Roll());
		t.start();
		container.add(jl);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	class Roll implements Runnable{

		@Override
		public void run() {
			while(count<=200) {
				jl.setBounds(count, 10, 200, 50);
				try {
					Thread.sleep(1000);
				}catch (Exception e) {
					e.printStackTrace();
				}
				count+=4;
				if(count==200)
					count=10;
			}
		}	
	}
	
	
	
	public static void main(String[] args) {
		new SwingAndThread();
	}
}
