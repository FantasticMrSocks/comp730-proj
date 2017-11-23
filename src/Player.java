public class Player  extends Character{	
	
	public Player(String n, int h, int s) {
		this.setName(n);
		this.setHP(h);
		this.setSTR(s);
		this.initialInventory();
	}

	public void open() {		
	}
										// inventory starts here:
	public void addItemToInv(String name){
	
		for(int i = 0; i < inv.length; i++) {
		if(inv[i] =="") {
			inv[i] = name;
			
	 System.out.println("You added " + name + " to your inventory.");
	}
		}
	System.out.println("Your inventory is full.");
		}
	public void printInv() {
		for(String x: inv) {
			System.out.println(x);
		}
	}
	public void removeItemFromInv (String name){
	for(int i = 0; i < inv.length; i ++){
	if(inv[i].equals(name)){
		inv[i] = "";
	}
		}
	System.out.println("That item isn't in your inventory.");
			}
	private static String inv[] = {"","","","","","","","","",""};
	//these are the directions we will use
		private int x, y;
		private boolean north, south, east, west;
		
		// set directions
		public void setNorth (boolean newNorth ) {
			north = newNorth;
		}
		public void setSouth (boolean newSouth) {
			south = newSouth;
		}
		public void setEast (boolean newEast) {
			east = newEast;
		}
		public void setWest (boolean newWest) {
			west = newWest;
		}
		
		//this returns X as Int
		public int getX () {
			return x;
		}
		
		//this will return Y as Int
		public int getY() {
			return y;
		}
		
		//required updates and checks
		public void update() {
			move();
		}
		//move player according to direction 
		public void move() {
			if(west) {
				x--;
			}
			if(east) {
				x++;
			}
			if(north) {
				y++;
			}
			if(south) {
				y--;
			}
		}
}