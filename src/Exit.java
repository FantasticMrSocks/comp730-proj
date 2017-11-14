public class Exit {
	public boolean visible = false;
	public Room connectedRoom;
	public String direction;
	
	public String getDescription() {
		String description = "This exit is to the " + direction;
		if (connectedRoom.visited) {
			description = description.concat("\nIt leads to " + connectedRoom);
		}
		return description;
	}
}
