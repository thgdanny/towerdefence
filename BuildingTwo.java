import java.awt.Color;
import java.awt.Graphics;

public class BuildingTwo extends Building {

	public Handler handler;
	
	public BuildingTwo(float x, float y, Handler handler) {
		super(x, y, handler);
		this.handler = handler;
	}

	@Override
	public void tick() {
		
		for(int i=0; i<handler.ens.size(); i++) {
			if(handler.calcDist(this, handler.ens.get(i)) < 150) {
				
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(100, 100, 50, 50);
	}
	
}
