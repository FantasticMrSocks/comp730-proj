import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class game {
	
	public static void main(String[] args) {		
		// Use case - Player attacks monster
		Player p = new Player("The Lord",100,10);
		Monster m = new Monster("Spider",50,5);
		
		List<Room> rooms = new ArrayList<Room>();
		
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.get(0).addHallway("east", rooms.get(1));
		rooms.get(1).addHallway("west", rooms.get(0));	
		
		rooms.get(0).addInformation("Restroom","a bathroom in a public building");// add name and description to a room
		rooms.get(1).addInformation("Field","a green field with nothing in it");// add name and description to a room
		
		p.addItem(new Inspectable ("Apple","a red delicious fruit")); // add an Apple into player inventory
		
		p.setRoom(rooms.get(1));
		System.out.println(p.inspect()); // inspect player
		p.move("west");                  // player move to west
		
		boolean exit = false;
		Scanner reader = new Scanner(System.in);
		String command = "";
		System.out.print ("Please enter a command: ");
		
		
		//player interaction happens here
		while (!exit) {
			command = reader.next();
			if (command.equals("quit")) {
				exit = true;
			}else if (command.equals("battle")) { // "The Lord" attacks "Spider" 
				p.battle(m);
			}
			if (command.equals("search")) {
				System.out.println(p.getRoom().inspect());
			}
			else if (command.equals("help")) {
				help();
			}
			else if (command.equals("east")) {
				p.move("east");
			}
			else if (command.equals("west")) {
				p.move("west");
			}
			else{
				System.out.println("unknown command");
			}
		}
		reader.close();
	}
	
	public void initializeGame() {
		//Whoops there should be something here
	}
	
	public static void help() {
		System.out.println ("-Player enters a labyrinth. He/she needs to get out by finding and defeating the final boss.");
		System.out.println ("-Player can move by inputing four movement commands: North (N), South (S), East (E), West (W). Each command can be abbreviated by a single letter.");
		System.out.println ("-Player can pick up an item with key word 'pick'+ item's name");
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
