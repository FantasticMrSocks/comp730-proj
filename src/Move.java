import java.util.List;

public class Player {
	//these are the directions we will use
	private int x, y;
	private booleen north, south, east, west;
	
	
	public void update () {
	//updates and checks
	}
	
	// set directions
	public void setNorth (booleen newNorth ) {
		north = newNorth;
	}
	public void setSouth (booleen newSouth) {
		south = newSouth;
	}
	public void setEast (booleen newEast) {
		east = newEast;
	}
	public void setWest (booleen newWest) {
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
