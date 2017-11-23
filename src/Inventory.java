import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Inspectable> inspectable;
	private int number;
	
	public Inventory() {
		inspectable = new ArrayList<Inspectable>(); 
		number = 0;
	}
	// get the number of items in the inventory
	public int getNumber() {
		return number;
	}
	// get the list of all items in the inventory
	public List<Inspectable> getItems() {
		return inspectable;
	}
	// get an Item at a specified position in this Inventory
	public Inspectable getItem(int i) {
		return inspectable.get(i);
	}
	// add an Item into this Inventory
	public void addItem(Inspectable i) {
		inspectable.add(i);
		number ++;
	}			
	// remove an Item at a specified position in this Inventory
	public void removeItem(Inspectable i) {
		inspectable.remove(i);
		number --;
	}
	// return an item at specified position and then remove it from this Inventory
	public Inspectable pickItem(int i) {
		Inspectable item = inspectable.get(i);
		inspectable.remove(i);
		number --;
		return item;
	}
	// return an specified item and then remove it from this Inventory
	public Inspectable pickItem(Inspectable it) {
		int i = inspectable.indexOf(it);			
		Inspectable item = inspectable.get(i);
		inspectable.remove(i);
		number --;
		return item;
	}		

}
