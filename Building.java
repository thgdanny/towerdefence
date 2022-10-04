import java.awt.Graphics;

public abstract class Building {

	public float x, y;
	public Handler handler;
	
	public Building(float x, float y, Handler handler) {
		this.x = x;
		this.y = y;
		this.handler = handler;
		handler.addBl(this);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);	
	
	public void fire(Enemy target) {
		
	}
	
}
