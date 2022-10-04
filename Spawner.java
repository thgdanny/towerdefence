
public class Spawner {

	public Handler handler;
	
	public Spawner(Handler handler) {
		this.handler = handler;
	}
	
	public void spawn(int round) {
		
		switch(round) {
			case 1:
				System.out.println("Round 1 begins...");
				new BuildingOne(100, 100, handler);
				new EnemyOne(250, 250, handler);
				break;
			case 2:
				System.out.println("Round 2 begins...");
				new EnemyOne(200, 200, handler);
				new EnemyOne(400, 400, handler);
				break;
			case 3:
				System.out.println("Round 3 begins...");
				new EnemyOne(200, 200, handler);
				new EnemyOne(400, 400, handler);
				new EnemyOne(600, 600, handler);
				break;
		}	
		
	}
	
}
