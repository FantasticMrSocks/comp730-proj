import java.util.List;

public class Character {
	private String name;	
	private Inventory inventory;
	private int hp;
	private int str;
	public Room currentRoom;
	private MyCoord location;
	
	public Character() {
		
	}	
	public Character(String n, int h, int s) {
		name = n;
		hp   = h;
		str  = s;
		inventory = new Inventory();
		location = new MyCoord();
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
	public void initialInventory(){
		inventory = new Inventory();
	}
	// add an item into the inventory
	public void addItem(Inspectable i){		
		inventory.addItem(i);
		System.out.println("You added " + i.inspect() + " to your inventory.");
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
	
	/* use an item: return the item and remove it from the Inventory
	public Inspectable useItem(Inspectable i) {
		inventory.removeItem(i);	
		return i;
	}*/
	
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
	// Set the location for character
	public void setLocation(MyCoord l) {
		location = l;
	}
	// get the current location of the character
	public MyCoord getLocation() {
		return location;
	}
	// Inspect the room and set the visited variable to true
	public String inspect() {		
		String result = "\nPlayer name: " + name + "\nStrength: "+ str+ "\nHealth: " +hp +"\n" ;				
		for (Inspectable i : inventory.getItems()) {
			result = result.concat("Inventory: \n" + i.inspect());
		}
		result = result.concat("\n" + "Location : X "+ location.getX()+ " Y "+ location.getY());
		return result;
	}	
	// move function
	public void move(String s) {
		if(s.equals("w")) {
			location.setX(location.getX()-1);			
		}else if(s.equals("e")) {
			location.setX(location.getX()+1);
		}else if(s.equals("n")) {
			location.setY(location.getY()+1);
		}else if(s.equals("s")) {
			location.setY(location.getY()-1);
		}
	}
	
}
