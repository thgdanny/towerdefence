import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	public float x, y;
	public float velX, velY;
	public Handler handler;
	public Enemy target;
	
	public Bullet(float x, float y, float velX, float velY, Enemy target, Handler handler) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.handler = handler;
		this.target = target;
		
		handler.addBul(this);
	}
	
	public void tick() {
		
		this.x = this.x + velX;
		this.x = handler.clamp(this.x);
		this.y = this.y + velY;
		this.y = handler.clamp(this.y);
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.drawRect((int) x, (int) y, 5, 5);
		
	}
	
}
