import java.util.List;

public class Room {
	private List<Exit> exits;
	private List<Inspectable> objects;
	public String name;
	public boolean visited;
	public String description;
	
	public String inspect() {
		String result = "";
		
		for (Exit exit : exits) {
			if (exit.visible) {
				result = result.concat(exit.getDescription() + "\n");
			}
		}
		
		for (Inspectable object : objects) {
			result = result.concat(object.inspect());
		}
		
		return result;
	}
}
