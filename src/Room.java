import java.util.List;

public class Room {
	private List<Exit> exits;
	private List<Inspectable> objects;
	public String name;
	public boolean visited;
	public String description;
	
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
