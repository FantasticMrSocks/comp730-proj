
public class Monster extends Character{

	public Monster(String n, int h, int s, int c) {
		this.setName(n);
		this.setHP(h);
		this.setSTR(s);
		this.setCrit(c);
		initialInventory();
	}

	// Inspect the monster
		public String inspect() {		
			String result = "There is a: " + this.getName() + "\nHealth: " +this.getHP() + "\nStrength: "+ this.getSTR() + "\nCritical ratio: "+ this.getCrit()+"\nIn this room." ;				
			for (Inspectable i : inventory.getItems()) {
				result = result.concat("\nIt has: \n" + i.inspect());
			}
			return result;
		}
	
}
