
public class Monster extends Character{

	public Monster(String n, int h, int s, int c) {
		this.setName(n);
		this.setHP(h);
		this.setSTR(s);
		this.setCrit(c);
		initialInventory();
	}
}
