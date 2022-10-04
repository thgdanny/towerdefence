import java.awt.Graphics;

public abstract class Enemy {

	public float x, y;
	public int hp;
	public Handler handler;
	
	public Enemy(float x, float y, int hp, Handler handler) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void receiveDmg(int dmg);
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
