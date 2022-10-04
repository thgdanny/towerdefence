import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 800, HEIGHT = 800;
	
	public Thread thread;
	public boolean running = false;
	
	public Handler handler;
	
	public int round = 1;
		
	public enum STATE {
		InTurn,
		OutTurn,
		Menu
	}
	
	public STATE gameState = STATE.InTurn;
	
	public Spawner spawner;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Tower Defence game", this);
		handler = new Handler(this);
		spawner = new Spawner(handler);
		spawner.spawn(round);
	}
	
	public void nextRound() {
		round++;
		spawner.spawn(round);
	}
	
	public void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double numTicks = 60.0;
		double ns = 1000000000 / numTicks;
		double delta = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
		}
		stop();
	}
	
	public void tick() {
		switch(gameState) {
			case InTurn:
				handler.tick();
			case OutTurn:
				//Allow buildings to be placed
			case Menu:
				//Menu	
		}	
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {		
		new Game();
	}
}
