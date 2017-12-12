import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class game {
	static final int maxWidth = 3;
	static final int maxHeight = 3;
	static final int maxRooms = 9;
	public static void main(String[] args) {		
		// Use case - Player attacks monster
		List<Monster> monsters = new ArrayList<Monster>(); // list of monsters
		Player p = new Player("The Lord",100,10,50);
		Monster m = new Monster("Spider",50,5,50);
		monsters.add(new Monster("Monkey",40,3,50));
		
		List<Room> rooms = new ArrayList<Room>();
		
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.add(new Room());
		
		rooms.get(0).addHallway("east", rooms.get(1));
		rooms.get(1).addHallway("west", rooms.get(0));	
		rooms.get(1).addHallway("north", rooms.get(2));
		rooms.get(2).addHallway("west", rooms.get(3));
		rooms.get(3).addHallway("north", rooms.get(4));
		rooms.get(4).addHallway("east", rooms.get(5));
		rooms.get(4).addHallway("northeast", rooms.get(6));
		rooms.get(5).addHallway("northwest", rooms.get(6));
		rooms.get(1).addHallway("east", rooms.get(7));
		rooms.get(7).addHallway("north", rooms.get(8));
		rooms.get(8).addHallway("up", rooms.get(9));
		rooms.get(9).addHallway("up", rooms.get(6));
		
		rooms.get(6).addHallway("southwest", rooms.get(4));
		rooms.get(6).addHallway("southeast", rooms.get(5));	
		rooms.get(5).addHallway("southwest", rooms.get(4));
		rooms.get(4).addHallway("south", rooms.get(3));
		rooms.get(3).addHallway("southeast", rooms.get(2));
		rooms.get(2).addHallway("south", rooms.get(1));
		rooms.get(7).addHallway("southwest", rooms.get(1));
		rooms.get(8).addHallway("south", rooms.get(7));
		rooms.get(9).addHallway("down", rooms.get(8));
		rooms.get(6).addHallway("east", rooms.get(9));
		
		rooms.get(0).addInformation("Restroom","A bathroom in a public building. I should get out of here and go explore. To the east there is a door leading outside. As the saying goes, 'There's nothing to see here.'");// add name and description to a room
		rooms.get(1).addInformation("Field", "A green field with nothing in it. To the southwest is the restroom, to the north is a door leading inside, to the east is the Garden.");// add name and description to a room
		rooms.get(2).addInformation("Storage", "An old dusty storage room with a shiny object. To the west is the kitchen, we can also go south to go back outside.");// add name and description to a room
		rooms.get(3).addInformation("Kitchen", "The kitchen, what messey people eat in this place. To the north is an office and to the southeast is the Storage closet."); // add name and description to a room
		rooms.get(4).addInformation("Office", "There are many desks and chairs here. We can move northeast to the Auditorium or east to the Meeting Room. We also can go south back to the kitchen.");// add name and description to a room
		rooms.get(5).addInformation("Meeting Room", "This is a meeting room, there is one large desk, many chairs, and a file drawer. The Auditorium is to the northwest and the Office to the southwest.");//add name and description to a room
		rooms.get(6).addInformation("Auditorium", "The auditorium is a huge space, something big with six legs is blocking the exit. We have the Office to the southwest and the Meeting Room to the southeast, and the Fire Ladder outside the window to the east");//add description to a room
		rooms.get(7).addInformation("Garden", "This is the garden, to the north is a fire escape, to the southwest is the field");
		rooms.get(8).addInformation("Fire Escape", "This is the outside Fire Escape, we can climb up the ladder in front of us or go south back to the Garden");
		rooms.get(9).addInformation("Fire Ladder", "This is the Fire Ladder, we can climb up and into the Auditorium or climb down to the bottom of the Fire Escape");

		
		
		rooms.get(0).addItem(new Inspectable ("Bread","an old bread")); // add a bread into the first room inventory
		rooms.get(7).addItem(new Inspectable ("lettuce", "some green to eat")); // add lettuce into the garden inventory
		rooms.get(3).addItem(new Inspectable ("pepper", "you always need pepper")); // add pepper into the kitchen inventory
		rooms.get(5).addItem(new Inspectable ("salt", "don't add too much"));
		rooms.get(9).addItem(new Inspectable ("turkey", "of the sliced variety"));
		p.addItem(new Inspectable ("Apple","a deciduous fruit")); // add an Apple into player inventory
		
		p.setRoom(rooms.get(0));
		System.out.println(p.inspect()); // inspect player
		//p.move("east");                   // player move to east
		//System.out.println(p.inspect());
		monsters.get(0).setRoom(rooms.get(0));
		monsters.get(0).addItem(new Inspectable ("Banana","an edible fruit")); // add an banana to the monkey
		boolean exit = false;
		Scanner reader = new Scanner(System.in);
		String command ;
		System.out.print ("Please enter a command: ");
		//player interaction happens here
		while (!exit) {
			command = reader.nextLine();
			if (command.toLowerCase().equals("quit")) {
				exit = true;
			}
			else if (command.toLowerCase().equals("battle")) { // "The Lord" attacks "Spider" 
				if (findMonster(p,monsters)!=null) 
				{
					p.battle(findMonster(p,monsters));
					System.out.println("Player has "+p.getHP()+ "Health");
					if (findMonster(p,monsters).getHP()<=0)
					{
						findMonster(p,monsters).dropItems();
					}						
				}
				else 
				{
					System.out.println("There is no monster in this room");
				}
			}
			else if (command.toLowerCase().equals("search")) { 
				System.out.println(p.getRoom().inspect());
				if (findMonster(p,monsters)!=null && findMonster(p,monsters).getHP()>0) // Only display the monster if it is still alive
					System.out.println(findMonster(p,monsters).inspect());				
			}
			else if (command.toLowerCase().equals("help")) {
				help();
			}
			else if (command.length()> 8 && command.substring(0,7).equals("inspect")) 
			{
				if (findItem(p, command.substring(8,command.length()))!= null)
					System.out.println(findItem(p, command.substring(8,command.length())).inspect()); // inspect an Item command.substring(8,command.length()))
				else
					System.out.println("There is no item with that name"); 
					
			}
			else if (command.substring(0, 4).equals("move")) {
				p.move(command.substring(4).trim());
			}
			else if (command.equals("inspect")) {
				System.out.println(p.inspect()); // inspect player
			}
			else if (command.length()>6 && (command.substring(0,4).equals("take")||command.substring(0,4).equals("pick"))){
				p.addItem(p.getRoom().removeItem(command.substring(5,command.length())));
			}
			else if(command.toLowerCase().equals("inspect"))
			{
				System.out.println(p.inspect());	
			}
			else{
				System.out.println("unknown command");
			}
		}
		reader.close();
	}
	
	public static Character findMonster(Player p,List<Monster> monsters) {
		for(Monster m : monsters) {
			if (p.getRoom()==m.getRoom()) {
				return m;
			}
		}
		return null;
	}
	public static Inspectable findItem(Player p, String s) {	
		// compare the name of item with all item in player's inventory
		for(Inspectable i : p.getInventory().getItems()) { // compare the name of item with all item in player's inventory
			if (i.getName().equals(s)) {
				return i;
			}
		}
		// compare the name of item with all item in the current room's inventory
		for(Inspectable j : p.getRoom().getInventory().getItems()) {
			if (j.getName().equals(s)) {
				return j;
			}
		}
		return null;
	}
	public static void help() {
		System.out.println ("-Player enters a labyrinth. He/she needs to get out by finding and defeating the final boss.");
		System.out.println ("-Player can move by inputing four movement commands: North (N), South (S), East (E), West (W). Each command can be abbreviated by a single letter.");
		System.out.println ("-Player can pick up an item with key word 'take' or 'pick'+ item's name");
		System.out.println ("-Player can use an item in his/her inventory with key word 'use' + item's name");
		System.out.println ("-Player can Inspect an item with the key word 'inspect' + item's name");
		System.out.println ("-Player can inspect the current location with the key word 'search'");
		System.out.println ("-Player can tracks his/her current location with the key word '???'");
		System.out.println ("-Player can check his/her inventory with the key word '???'");
		System.out.println ("-Player can request help with the key word 'help' ");
		System.out.println ("-Some of the rooms are required specific keys to unlock. ");
		System.out.println ("-If a player enter a room which has a monster; he/she will enter a FIGHT.");
		System.out.println ("-If the player gets killed by a monster, he/she will be move to the starting point.");
		System.out.println ("-Player can increase his/her strength by pick up a weapon.");
	}
}
