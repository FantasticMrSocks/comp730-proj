import java.util.List;

public class Room {
	private List<Exit> exits;
	private List<Inspectable> objects;
	public String name;
	public boolean visited;
	public String description;
	
	public Room(List<Exit> exits, List<Inspectable> objects) {
		for (Exit newExit : exits) {
			exits.add(newExit);
		}
		
		for (Inspectable newObject : objects) {
			objects.add(newObject);
		}
	}

	public Room(List<Exit> exits) {
		for (Exit newExit : exits) {
			exits.add(newExit);
		}
	}
	
	public Room(){}
	
	public void addExit(Exit newExit) {
		exits.add(newExit);
	}
	
	public String inspect() {
		String result = "Current room: " + name + "\n" + description;
		
		for (Exit exit : exits) {
			if (exit.visible) {
				result = result.concat("\n" + exit.getDescription());
			}
		}
		
		for (Inspectable object : objects) {
			result = result.concat("\n" + object.inspect());
		}
		
		return result;
	}
}
