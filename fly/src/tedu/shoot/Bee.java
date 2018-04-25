package tedu.shoot;

public class Bee extends Enemy implements Award{
	int dx;
	public Bee() {
		img=Main.bees[0];
		imgs=Main.bees;
		stepPx=5;
		life=1;
		damage=0;
		init();
	}
	public void init() {
		super.init();
		if(Math.random()<0.5) {
			dx=-1;
		}else {
			dx=1;
		}
	}
	public void step() {
		super.step();
		x+=dx;
	}
	@Override
	public int getLife() {
		return 1;
	}
	@Override
	public Weapon getWeapon(int level) {
		if(level<0||level>=Main.weapons.length)
			return Main.weapons[0];
		if(level>=Main.weapons.length)
			return Main.weapons[Main.weapons.length-1];
		return Main.weapons[level];
	}
}
