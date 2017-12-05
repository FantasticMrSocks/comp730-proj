public class Player  extends Character{	
	
	public Player(String n, int h, int s, int c) {
		this.setName(n);
		this.setHP(h);
		this.setSTR(s);
		this.setCrit(c);
		this.initialInventory();
	}

	//taking an item from a room and putting it in 
	public void takeItem(Item item) {
		Inspectable myitem = currentRoom.inventory.pickItem(item);
		inventory.addItem(myitem);
}
}