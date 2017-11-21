public class Exit {
	public boolean visible = false;
	private Room connectedRoom;
	private String direction;
	
	public Exit(Room nextRoom, String where){
		connectedRoom = nextRoom;
		direction = where;
	}
	
	public String getDescription() {
		String description = "This exit is to the " + direction;
		if (connectedRoom.visited) {
			description = description.concat("\nIt leads to " + connectedRoom);
		}
		return description;
	}
}
