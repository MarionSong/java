package tedu.shoot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	static final int STATUS_NOT_START=0;
	static final int STATUS_RUN=1;
	static final int STATUS_OVER=2;
	static final int STATUS_PAUSE=3;
	Background bg=new Background();
	Hero hero=new Hero();
	//存放所有敌人的列表
	ArrayList<Enemy> enemys=new ArrayList<>();
	//存放所有子弹的列表
	ArrayList<Bullet> bullets = new ArrayList<>();
	//静态的帧计数变量
	static int counter;
	//游戏状态
	int status=STATUS_NOT_START;

	public GamePanel() {
		//设置面板的期望大小
		setPreferredSize(new Dimension(400, 654));
	}
	@Override
	public void paint(Graphics g) {
		bg.paint(g);
		hero.paint(g);
		paintEnemy(g);
		paintBullet(g);
		//绘制得分和英雄生命
		paintScore(g);
		if(status==STATUS_NOT_START) {
			g.drawImage(Main.start,0,0,null);
		}else if(status==STATUS_OVER) {
			g.drawImage(Main.over,0,0,null);
		}else if(status==STATUS_PAUSE) {
			g.drawImage(Main.pause,0,0,null);
		}
		
	}
	private void paintScore(Graphics g) {
		Font font=new Font(Font.SANS_SERIF,Font.BOLD,14);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("生命", 8, 20);
		g.drawString(""+hero.life,160,20);
		g.drawString("得分"+hero.score,8, 36);
		
		g.setColor(Color.WHITE);
		g.drawString("生命", 7, 19);
		g.drawString(""+hero.life,159,19);
		g.drawString("得分"+hero.score,7, 35);
		
		g.setColor(Color.BLACK);
		g.drawRect(52, 8, 100, 14);
		g.setColor(Color.RED);
		g.fillRect(54,9,98*hero.life/10,12);
		
		
		
	}
	private void paintBullet(Graphics g) {
		for (Iterator iterator = bullets.iterator(); iterator.hasNext();) {
			Bullet b = (Bullet) iterator.next();
			b.paint(g);
		}
	}
	private void paintEnemy(Graphics g) {
		for (Iterator iterator = enemys.iterator(); iterator.hasNext();) {
			Enemy e = (Enemy) iterator.next();
			e.paint(g);
		}
	}
	//动起来
	public void action() {
		//监听器监听鼠标在面板上的动作
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(status==STATUS_RUN||status==STATUS_NOT_START)
				//设置英雄要移动到的新的目标位置
					hero.moveTo(e.getX(), e.getY());
			}
		});
		//添加戍边监听器，监听点击，进入和离开
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(status==STATUS_NOT_START)
					status=STATUS_RUN;
				else if(status==STATUS_OVER) {
					status=STATUS_NOT_START;
					hero=new Hero();
					enemys.clear();
					bullets.clear();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(status==STATUS_PAUSE)
					status=STATUS_RUN;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(status==STATUS_RUN) {
					status=STATUS_PAUSE;
				}
			}
			
		});
		
		/*
		 * 计时器：jdk中，提供了一个而执行定时间隔任务的工具，可以固定时间频率
		 *来执行指定的任务代码
		 *以60fps速率来执行
		 */
		//新建计时器对象
		Timer timer=new Timer(); 
		//用计时器来安排任务代码的执行日程,任务代码，立即执行，间隔时间
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				counter++;
				if(status==STATUS_NOT_START) {
					hero.step();
					bg.step();
					bulletIn();
					bulletStep();
				}else if(status==STATUS_RUN) {
					bg.step();
					hero.step();
					if(hero.isDead()) {
						status=STATUS_OVER;
					}
					enemyIn();
					enemyStep();
					bulletIn();
					bulletStep();
					pengZhuang();
				}else if(status==STATUS_OVER) {
					bg.step();
					enemyIn();
					enemyStep();
				}
			
				
				repaint();
			}
		},0,1000/60);
	}
	protected void pengZhuang() {
		//遍历敌人
		for (Iterator it1 = enemys.iterator(); it1.hasNext();) {
			Enemy e = (Enemy) it1.next();
			if(e.isExplode()||e.isDead()) {
				continue;//处理下一个敌人
			}
			//遍历子弹
			for (Iterator it2 = bullets.iterator(); it2.hasNext();) {
				Bullet b = (Bullet) it2.next();
				if(e.hit(b)) {//敌人碰撞子弹
					it2.remove();//子弹移除
					
				}
			}
			//敌人碰撞英雄
			if(hero.isNormal()&&e.hit(hero)) {
			//敌人e是否是Award子类
				if(e instanceof Award) {
					Award a=(Award) e;
					hero.life+=a.getLife();
					if(hero.life>10)
						hero.life=10;
					//英雄级别还没有到最高级
					if(hero.level<Main.weapons.length-1)
						hero.weapon=a.getWeapon(++hero.level);
						
				}
				else {
					//英雄级别还没到最低0
					if(hero.level>0) {
						hero.weapon=Main.weapons[--hero.level];
					}
				}
			}
			
		}
		
	}
	protected void bulletStep() {
		//迭代遍历
		for (Iterator it = bullets.iterator(); it.hasNext();) {
			Bullet b = (Bullet) it.next();
			b.step();
			if(b.isOut()) {
				it.remove();
			}
		}

	}
	protected void bulletIn() {
		if(hero.isDead()) {
			return;
		}
		if(counter%2 != 0) return;
		//英雄射击
		Bullet[] a = hero.shoot();
		//发射的子弹加入子弹列表
		for (int i = 0; i < a.length; i++) {
			Bullet b = a[i];
			if(b != null) {
				bullets.add(b);
			}
		}
	}
	protected void enemyStep() {
		//迭代遍历
		for (Iterator it = enemys.iterator(); it.hasNext();) {
			Enemy e = (Enemy) it.next();
			if(e.isDead()) {
				hero.score+=e.score;
				it.remove();
				continue;
			}
			e.step();
			if(e.isOut()) {//如果敌机走出画面从列表删除这个敌人
				it.remove();
			}
		}
	}
	protected void enemyIn() {
		/*
		 * 每半秒30帧出现一个敌人，三种敌人随机出现，60%小飞机,30%大飞机，10%小蜜蜂
		 */
		if(counter%15!=0) return;
		double d=Math.random();
		if(d<0.6) {
			enemys.add(new Airplane());
		}else if(d<0.9) {
			enemys.add(new Bigplane());
		}else {
			enemys.add(new Bee());
		}
				
	}
	
}
