import java.util.List;

public class Inventory {
	private List<Inspectable> inspectable;
	
	public Inventory() {
		
	}
	// add an Item into this Inventory
	public void addItem(Inspectable i) {
		inspectable.add(i);
	}	
	// get an Item at a specified position in this Inventory
	public Inspectable getItem(int i) {
		return inspectable.get(i);
	}
	// remove an Item at a specified position in this Inventory
	public void removeItem(Inspectable i) {
		inspectable.remove(i);
	}
	// return an item at specified position and then remove it from this Inventory
	public Inspectable pickItem(int i) {
		Inspectable item = inspectable.get(i);
		inspectable.remove(i);
		return item;
	}
	// return an specified item and then remove it from this Inventory
	public Inspectable pickItem(Inspectable it) {
		int i = inspectable.indexOf(it);			
		Inspectable item = inspectable.get(i);
		inspectable.remove(i);
		return item;
	}		

}
