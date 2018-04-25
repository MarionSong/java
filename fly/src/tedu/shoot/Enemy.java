package tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {
	BufferedImage img;
	int x;
	int y;
	int stepPx;
	//生命值life
	int life;
	//对英雄的伤害
	int damage;
	//敌机值几分
	int score;
	static final int STATUS_NORMAL=0;
	static final int STATUS_EXPLODE=1;
	static final int STATUS_DEAD=2;
	BufferedImage[] imgs;
	//当前图片下标,用来处理爆炸的
	int curIndex;
	//当前的状态
	int status=STATUS_NORMAL;
	public void step() {
		if(status==STATUS_NORMAL)
			y+=stepPx;
		else if(status==STATUS_EXPLODE){
			//切换图片
			if(GamePanel.counter%6==0) {
				curIndex++;
				if(curIndex>=5) {
					status=STATUS_DEAD;
					return;
				}
				img=imgs[curIndex];
			}
		}
	}
	public boolean isOut() {//判断敌机是否出边界
		return x<=-img.getWidth()||x>=400||y>=654;
	};
	
	public void init() {//初始化敌机位置
		y=-img.getHeight();
		x=new Random().nextInt(400-img.getWidth());
	}

	public void paint(Graphics g) {
		g.drawImage(img,x,y,null);
	}
	public boolean hit(Hero hero) {
		//敌人半径
		int r1=img.getHeight()/2;
		//敌人中心点
		int x1=x+img.getWidth()/2;
		int y1=y+img.getHeight()/2;
		//英雄半径
		int r2=hero.img.getHeight()/2;
		//英雄中心点
		int x2=hero.x+hero.img.getWidth()/2;
		int y2=hero.y+hero.img.getHeight()/2;
		int dx=x1-x2;
		int dy=y1-y2;
		//敌人和英雄碰撞
		boolean bol=Math.sqrt(dx*dx+dy*dy)<=r1+r2;
		if(bol) {
			//敌人
			life=0;
			status=STATUS_EXPLODE;
			//英雄
			hero.life-=damage;
			if(hero.life<=0) {
				hero.life=0;
				hero.status=Hero.STATUS_EXPLPDE;
			}
			else
				hero.status=Hero.STATUS_HURT;
		}
		return Math.sqrt(dx*dx+dy*dy)<=r1+r2;
		
	}
	
	
	
	public boolean hit(Bullet b) {
		int r=img.getHeight()/2;
		int x1=x+img.getWidth()/2;
		int y1=y+img.getHeight()/2;
		int dx=x1-b.x;
		int dy=y1-b.y;
		boolean bol=Math.sqrt(dx*dx+dy*dy)<=r;
		if(bol) {
			life--;
			if(life<=0) {
				life=0;
				status=STATUS_EXPLODE;
			}
		}
		return bol;
	}
	public boolean isNormal() {
		return status==STATUS_NORMAL;
	}
	public boolean isExplode() {
		return status==STATUS_EXPLODE;
	}
	public boolean isDead() {
		return status==STATUS_DEAD;
	}
	
	
	
}
