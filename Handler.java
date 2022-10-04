import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {

	public ArrayList<Building> bls = new ArrayList<Building>();
	public ArrayList<Enemy> ens = new ArrayList<Enemy>();
	public ArrayList<Bullet> bul = new ArrayList<Bullet>();
	public Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public float clamp(float num) {
		float cl;
		if(num > 750) {
			cl = 750;
		} else if(num < 0) {
			cl = 0;
		} else {
			cl = num;
		}
		return cl;
	}
	
	public void tick() {
		for(int i=0; i<bls.size(); i++) {
			bls.get(i).tick();
		}
		if(ens.size() == 0) {
			game.nextRound();
		} else {
			for(int i=0; i<ens.size(); i++) {
				ens.get(i).tick();
			}
		}
		for(int i=0; i<bul.size(); i++) {
			bul.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<bls.size(); i++) {
			bls.get(i).render(g);
		}
		for(int i=0; i<ens.size(); i++) {
			ens.get(i).render(g);
		}
		for(int i=0; i<bul.size(); i++) {
			bul.get(i).render(g);
		}
	}
	
	public void addBl(Building bl) {
		bls.add(bl);
	}
	
	public void addEn(Enemy en) {
		ens.add(en);
	}
	
	public void addBul(Bullet bullet) {
		bul.add(bullet);
	}
	
	public float calcDist(Building bl, Enemy en) {
		float tx = Math.abs(bl.x - en.getX());
		float ty = Math.abs(bl.y - en.getY());
		return (float) Math.sqrt(Math.pow(tx, 2) + Math.pow(ty, 2));
	}
	
}
