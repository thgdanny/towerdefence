import java.awt.Color;
import java.awt.Graphics;

public class EnemyOne extends Enemy {

	private float velX = 0;
	private float velY = 0;
	
	public float x, y;
	
	private int hitCount = 60;
	
	public Handler handler;
	
	public int hp;
	
	public EnemyOne(int x, int y, Handler handler) {
		super(x, y, 100, handler);
		this.x = x;
		this.y = y;
		this.hp = 100;
		this.handler = handler;
		handler.addEn(this);
	}
	
	public void receiveDmg(int dmg) {
		hp -= dmg;
	}
	
	@Override
	public void tick() {
		while(hitCount >= 0) {
			System.out.println(hitCount);
			hitCount--;
		}
		this.x = this.x + velX;
		this.x = handler.clamp(this.x);
		
		this.y = this.y + velY;
		this.y = handler.clamp(this.y);
		
		if(hp <= 0) {
			for(int i=0; i<handler.ens.size(); i++) {
				if(handler.ens.get(i) == this) {
					handler.ens.remove(i);
					System.out.println("Enemy has died");
				}
			}
		}
				
	}

	@Override
	public void render(Graphics g) {
		while(hitCount == 0) {
			g.setColor(Color.yellow);
			g.fillOval((int) x, (int) y, 50, 50);			
		}
			g.setColor(Color.red);
			g.fillOval((int) x, (int) y, 50, 50);
			
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
}
