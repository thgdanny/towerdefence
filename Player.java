import java.util.Random;

public class Player {

	public int num;
	public int health;
	public int attack;
	public int defence;
	
	public Player(int num, int health, int attack, int defence) {
		this.num = num;
		this.health = health;
		this.attack = attack;
		this.defence = defence;
	}
	
	public void tick() {
		
	}
	
	public void setHealth(int toSet) {
		this.health = toSet;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	public int getDefence() {
		return this.defence;
	}
	
	public double rollCrit() {
		
		Random r = new Random();
		
		if((r.nextInt(99)+1) <= 5) { // 5% chance of rolling a crit
			return r.nextDouble(1)+1;
		} else {
			return 0;
		}
		
	}
	
	public void attackPlayer(Player player) {
		
		//Special attacks
		
		if(player.getHealth() > 0) {
			
			int attackedHealth = player.getHealth();
			
			double crit = rollCrit();
			if(crit != 0) {
				player.setHealth(attackedHealth - (int) (this.attack*crit)); // crit
				System.out.println("CRIT");
			} else {			
				player.setHealth(attackedHealth - this.attack); // no crit
			}
			
			this.setHealth(this.health - player.getDefence());
			System.out.println(player.getHealth());
			
			System.out.println("Player " + this.num + " has attacked Player " + player.num + " for " + (attackedHealth-this.health) + " damage");
			
			System.out.println(player);
			
		}
		
	}
	
}
