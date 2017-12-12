import java.util.List;
import java.util.HashMap;

public class Room {
	//private List<Inspectable> objects;
	protected Inventory inventory;
	public String name;
	public boolean visited;
	public String description;
	
	private HashMap<String, Room> hallways;
	
	// Constructor
	public Room(){
		inventory = new Inventory();
		name ="";
		description ="";
		visited =false;
		hallways = new HashMap<String, Room>();
	}

	// add an Exit into a room
	public void addHallway(String direction, Room adjacentRoom) {
		hallways.put(direction, adjacentRoom);
	}
	// give a name of an item, remove that Item from the Inventory
	public Inspectable removeItem(String n) {		
		for(Inspectable item : this.inventory.getItems()) {
			if(item.getName().equals(n)) {				
				this.inventory.removeItem(item);
				return item;
			}
		}
		return null;				
	}
	
	public Room getNextRoom(String direction) {
		if (hallways.containsKey(direction)) {
			return hallways.get(direction);
		} else {
			return null;
		}
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
	
	public Inventory getInventory() {
		return inventory;
	}
	// Inspect the room and set the visited variable to true
	public String inspect() {
		visited = true;
		String result = "Room: " + name + "\n" + description;
		
		String exits = "Exits are";
		for (String direction : hallways.keySet()) {
			exits = exits.concat(" " + direction + ",");
		}
		exits = exits.substring(0, exits.length() - 1) + "\n";
		
		for (Inspectable i : inventory.getItems()) {
			result = result.concat("\n" + i.inspect());
		}
		return result + "\n" + exits;
	}
}
