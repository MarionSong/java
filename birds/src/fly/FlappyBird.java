package fly;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.sun.javafx.tools.packager.Main;

public class FlappyBird {
	static BufferedImage bgImg;
	static BufferedImage columnImg;
	static BufferedImage groundImg;
	static BufferedImage birdImg;
	static BufferedImage startImg;
	static BufferedImage overImg;
	public static void main(String[] args) throws IOException {
		bgImg=ImageIO.read(FlappyBird.class.getResource("/imgs/bg.png"));
		columnImg=ImageIO.read(FlappyBird.class.getResource("/imgs/column.png"));
		groundImg=ImageIO.read(FlappyBird.class.getResource("/imgs/ground.png"));               
		birdImg=ImageIO.read(FlappyBird.class.getResource("/imgs/0.png"));
		startImg=ImageIO.read(FlappyBird.class.getResource("/imgs/start.png"));
		overImg=ImageIO.read(FlappyBird.class.getResource("/imgs/gameover.png"));
		JFrame f=new JFrame();
		f.setTitle("FlappyBirds");
		f.setResizable(false);
		f.setSize(300,200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel game=new GamePanel();
		f.add(game);
		f.pack();
		f.setVisible(true);
		game.action();
		
	}

}
