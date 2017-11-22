public class Player  extends Character{	
	
	private Inventory backpack;
	
	public Player(String n, int h, int s) {
		setName(n);
		setHP(h);
		setSTR(s);
		backpack = new Inventory();
	}

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