public class Character {
	private String name;	
	private int hp;
	private int str;
	private String currentRoom;
	//private int id;
	//private int lv;
	
	public Character() {
		
	}	
	public Character(String n, int h, int s) {
		name = n;
		hp   = h;
		str  = s;
	}	
	public int getHP(){
		return hp;
	}
	public void setHP(int health){
		hp = health;
	}
	public String getName(){
		return name;
	}
	public void setName(String n){
		name = n;
	}
	public int getSTR(){
		return str;
	}
	public void setSTR(int s){
		str = s;
	}
	
	// This function will update the HP to the target character after being hit
	public void attack(Character c) {
		c.setHP(c.getHP()- this.getSTR()); // the new HP will be store
		System.out.println(this.getName()+" attack "+c.getName()+", "+c.getName()+" is received "+this.getSTR()+ " damages");
	}
	
	// This function will let the current character and the opponent attack each other until one of them dies
	public Character battle(Character m) {
		while(true) {
			this.attack(m); 
			if (m.death()) {  // If the HP of the opponent <= 0
				return this;  // The current character will be the winner
			}
			m.attack(this); 
			if (this.death()) {	// If the HP of current character <= 0			
				return m; 		// The the opponent will be the winner
			}			
		}		
	}
	
	// This function will return true if the character's HP <=0
	public boolean death() {
		if (hp <= 0) {
			System.out.println(this.name +" has been slaughtered");
			return true;
		}
		else {
			return false;
		}			
	}
}
