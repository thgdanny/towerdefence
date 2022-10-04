import java.awt.Color;
import java.awt.Graphics;

public class BuildingOne extends Building {
	
	public Handler handler;
	
	public BuildingOne(float x, float y, Handler handler) {
		super(x, y, handler);
		this.handler = handler;
	}
	
	public float disX(Building org, Enemy enm) {
		return org.x - enm.getX();
	}
	
	public float disY(Building org, Enemy enm) {
		return org.y - enm.getY();
	}
	
	public void fire(int i) {
		float xm = disX(this, handler.ens.get(i));
		float ym = disY(this, handler.ens.get(i));
		float ratio = xm/ym;
		new Bullet(this.x, this.y, 5, ratio*5, handler.ens.get(i), handler);
		//handler.ens.get(i).hp -= 5;
		handler.ens.get(i).receiveDmg(2);
		System.out.println("Pew");
	}
	
	@Override
	public void tick() {
		for(int i=0; i<handler.ens.size(); i++) {
			float dist = handler.calcDist(this, handler.ens.get(i));
			
			if(dist < 250) {
				fire(i);
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(100, 100, 100, 100);
	}
	
}
