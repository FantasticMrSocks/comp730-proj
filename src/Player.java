public class Player  extends Character{	
	
	public Player(String n, int h, int s) {
		this.setName(n);
		this.setHP(h);
		this.setSTR(s);
	}
	public void move() {		
	}
	public void open() {		
	}
										// inventory starts here:
public void addItemToInv(String name){

	for(int i = 0; i < inv.length; i++) {
	if(inv[i] =="") {
		inv[i] = name;
		
 System.out.println("You added " + name + " to your inventory.");
}
	}
System.out.println("Your inventory is full.");
	}
public void printInv() {
for(String x: inv);
char[] x = null;         //this piece wasn't shown in the inventory walkthrough
System.out.println(x);   // but this wouldn't work correctly with out it.
}
public void removeItemFromInv (String name){
for(int i = 0; i < inv.length; i ++){
if(inv[i].equals(name)){
	inv[i] = "";
}
	}
System.out.println("That item isn't in your inventory.");
		}
private static String inv[] = {"","","","","","","","","",""};
}