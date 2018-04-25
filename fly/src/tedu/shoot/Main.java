package tedu.shoot;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {
	static BufferedImage[] airplanes=new BufferedImage[5];
	static BufferedImage[] bees=new BufferedImage[5];
	static BufferedImage[] bigplanes=new BufferedImage[5];
	static BufferedImage[] heros=new BufferedImage[6];
	static BufferedImage bg;
	static BufferedImage bullet;
	static BufferedImage start;
	static BufferedImage over;
	static BufferedImage pause;
	public static Weapon[] weapons= {new SingleWeapon(),new DoubleWeapon(),new FourWeapon()};
	public static void main(String[] args) throws IOException {
		bg=ImageIO.read(Main.class.getResource("/imgs/background.png"));
		bullet=ImageIO.read(Main.class.getResource("/imgs/bullet.png"));
		start=ImageIO.read(Main.class.getResource("/imgs/start.png"));
		over=ImageIO.read(Main.class.getResource("/imgs/gameover.png"));
		pause=ImageIO.read(Main.class.getResource("/imgs/pause.png"));
		for(int i=0;i<5;i++) {
			airplanes[i]=ImageIO.read(Main.class.getResource("/imgs/airplane"+i+".png"));
		}
		for(int i=0;i<5;i++) {
			bees[i]=ImageIO.read(Main.class.getResource("/imgs/bee"+i+".png"));
		}
		for(int i=0;i<5;i++) {
			bigplanes[i]=ImageIO.read(Main.class.getResource("/imgs/bigplane"+i+".png"));
		}
		for(int i=0;i<6;i++) {
			heros[i]=ImageIO.read(Main.class.getResource("/imgs/hero"+i+".png"));
		}
		JFrame f=new JFrame();
		f.setTitle("飞机大战");
		f.setSize(480,654);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//面板
		GamePanel game=new GamePanel();
		f.add(game);
		//让窗口适应内部面板大小
		f.pack();
		f.setVisible(true);
		game.action();
		
	}
	

}
