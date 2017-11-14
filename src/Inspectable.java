public class Inspectable {
	public boolean visible;
	public String name;
	public String inspect() {
		String description = "You see a " + name;
		
		return description;
	}
}
