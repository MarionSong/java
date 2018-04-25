package tedu.shoot;

public class Airplane extends Enemy{
	public Airplane() {
		img=Main.airplanes[0];
		imgs=Main.airplanes;
		stepPx=4;
		life=2;
		damage=1;
		score=1;
		init();
	}
	
}
