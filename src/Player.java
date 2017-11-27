public class Player  extends Character{	
	
	public Player(String n, int h, int s) {
		this.setName(n);
		this.setHP(h);
		this.setSTR(s);
		this.initialInventory();
	}
}