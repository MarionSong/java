package tedu.shoot;

public class Bigplane extends Enemy{
	public Bigplane() {
		img=Main.bigplanes[0];
		imgs=Main.bigplanes;
		stepPx=1;
		life=30;
		damage=2;
		score=2;
		init();
	}
}
