import java.util.ArrayList;
import java.util.List;

public class Room {
	private List<Exit> exits;
	//private List<Inspectable> objects;
	private Inventory inventory;
	public String name;
	public boolean visited;
	public String description;
	private MyCoord location;
	
	// Constructor
	public Room(){
		exits = new ArrayList<Exit>();
		inventory = new Inventory();
		name ="";
		description ="";
		visited =false;
	}
	/*
	public Room(List<Exit> exits, List<Inspectable> objects) {
		for (Exit newExit : exits) {
			exits.add(newExit);
		}
		
		for (Inspectable newObject : objects) {
			objects.add(newObject);
		}
	}*/
	
	public Room(List<Exit> e, Inventory i) {
		exits = e;
		inventory = i;
	}
	/*
	public Room(List<Exit> exits) {
		for (Exit newExit : exits) {
			exits.add(newExit);
		}
	}*/	
	
	// add a list of Exits into a room
	public void addExit(List<Exit> e) {
		for (Exit newExit : e) {
			exits.add(newExit);
		}
	}
	
	// add an Exit into a room
	public void addExit(Exit newExit) {
		exits.add(newExit);
	}
	
	// add an item into a room
	public void addItem(Inspectable i) {
		inventory.addItem(i);
	}
	// add a List of item into a room
	public void addItems(List<Inspectable> objects) {
		for (Inspectable newObject : objects) {
			inventory.addItem(newObject);
		}
	}
	// Add name and description for a room
	public void addInformation(String n, String d) {
		name = n;
		description = d;		
	}
	
	// Inspect the room and set the visited variable to true
	public String inspect() {
		visited = true;
		String result = "Current room: " + name + "\n" + description;
		
		for (Exit exit : exits) {
			if (exit.visible) {
				result = result.concat("\n" + exit.getDescription());
			}
		}		
		for (Inspectable i : inventory.getItems()) {
			result = result.concat("\n" + i.inspect());
		}
		result = result.concat("\n" + "Location : X "+ location.getX()+ " Y "+ location.getY());
		return result;
	}
	// Set the location for the room
	public void setLocation(MyCoord l) {
		location = l;
	}
	// get the current location of the character
	public MyCoord getLocation() {
		return location;
	}
}
