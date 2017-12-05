import java.util.List;

public class Character {
	private String name;	
	protected Inventory inventory;
	private int hp;
	private int str;
	private int crit;    // Critical ratio, range [0-100] ==> [0%-100%] ratio
	protected Room currentRoom;
	
	public Character() {
		
	}	
	public Character(String n, int h, int s, int c,Room r) {
		name = n;
		hp   = h;
		str  = s;
		crit =c;
		inventory = new Inventory();
		currentRoom = r;
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
	public int getCrit(){
		return crit;
	}
	public void setCrit(int n){
		crit = n;
	}
	public void initialInventory(){
		inventory = new Inventory();
	}
	// add an item into the inventory
	public void addItem(Inspectable i){		
		if( i !=null) {
		inventory.addItem(i);
		System.out.println("You added " + i.inspect() + " to your inventory.");
		}
		else {
			System.out.println("There are no item to add");
		}
			
	}
	// add a List of item into a room
	public void addItems(List<Inspectable> objects) {
		for (Inspectable newObject : objects) {
			inventory.addItem(newObject);
		}
	}
	// remove an item from the Inventory
	public void removeItem(Inspectable i){
		inventory.removeItem(i);
	}
	
	// This function will update the HP to the target character after being hit
	public void attack(Character c) {
		if (this.critical()==1) { // if the attack is critical
			c.setHP(c.getHP()- 2*this.getSTR()); // The dam deal will be double
			System.out.println(this.getName()+" attack "+c.getName()+" with a critical hit, "+c.getName()+" is received "+2*this.getSTR()+ " damages");
		}else {
			c.setHP(c.getHP()- this.getSTR());	// the dam deal will be normal
			System.out.println(this.getName()+" attack "+c.getName()+", "+c.getName()+" is received "+this.getSTR()+ " damages");
		}		 		
	}
	// This function will decide the next attack will be a critical one or not
	public int critical() {
		if ((Math.random() * 100 <= this.getCrit())){
			return 1;
		}else
			return 0;
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
	// Set the location for character
	public void setRoom(Room r) {
		currentRoom = r;
	}
	// get the current location of the character
	public Room getRoom() {
		return currentRoom;
	}
	// Inspect the room and set the visited variable to true
	public String inspect() {		
		String result = "\nPlayer name: " + name + "\nHealth: " +hp + "\nStrength: "+ str + "\nCritical ratio: "+ crit+"\n" ;				
		for (Inspectable i : inventory.getItems()) {
			result = result.concat("Inventory: \n" + i.inspect());
		}
		return result;
	}	
	// move function
	public void move(String s) {
		if (currentRoom.getNextRoom(s) != null) {
			setRoom(currentRoom.getNextRoom(s));
			System.out.println("You move to the " + s);
			System.out.println(currentRoom.inspect());
		} else {
			System.out.println("There's nowhere to go in that direction.");
		}
	}
	
}
