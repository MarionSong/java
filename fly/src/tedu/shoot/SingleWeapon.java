package tedu.shoot;

public class SingleWeapon implements Weapon{

	@Override
	public Bullet[] fire(Hero hero) {
		Bullet b=new Bullet();
		b.x=hero.x+hero.img.getWidth()/2-3;
		b.y=hero.y-b.img.getHeight();
		return new Bullet[] {b};
	}
	
}
