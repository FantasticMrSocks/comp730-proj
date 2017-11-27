public class Inspectable {
	public boolean visible;
	public String name;
	public String description;
	
	public Inspectable(String n, String d) {
		visible = true;
		name = n;
		description =d;
	}
	public void setVisible (boolean v) {
		visible = v;
	}
	
	public String inspect() {
		String d = name + ": " + description;		
		return d;
	}
}
