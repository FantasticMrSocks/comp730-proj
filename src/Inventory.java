import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public void addItem(Item toAdd) {
		items.add(toAdd);
	}
	
	public void removeItem(Item toRemove) {
		items.remove(toRemove);
	}
	
	public String listItems() {
		String list = "";
		
		for (Item i : items) {
			list = list.concat(i.name + "\n");
		}
		
		return list;
	}
}
