public class CharacterAbstract {
	private String name;
	//private int id;
	//private int lv;
	private int hp;
	private int str;
	public CharacterAbstract() {
		
	}	
	public CharacterAbstract(String n, int h, int s) {
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
	public void attack(CharacterAbstract c) {
		c.setHP(c.getHP()- this.getSTR());
		System.out.println(this.getName()+" attack "+c.getName()+", "+c.getName()+" is received "+this.getSTR()+ " damages");
	}	
	public CharacterAbstract battle(CharacterAbstract m) {
		while(true) {
			this.attack(m); 
			if (m.death()) {
				return this;  // The winner
			}
			m.attack(this); 
			if (this.death()) {				
				return m; // The winner
			}			
		}		
	}
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
