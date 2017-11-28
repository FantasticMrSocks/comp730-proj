import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class game {
	
	static final int maxWidth = 3;
	static final int maxHeight = 3;
	static final int maxRooms = 9;
	
	
	public static void main(String[] args) {
		List<Room> rooms = new ArrayList<Room>(); // list of rooms
		int k =0;
		List<MyCoord> map = new ArrayList<MyCoord>(); // list of locations
		for (int i =0; i<maxWidth; i++) {
			for (int j = 0; j<maxHeight; j++){
				map.add(new MyCoord(i,j)); // Initialize 9 locations
				rooms.add(new Room()); // Initialize for room 1 -9
				rooms.get(k).setLocation(map.get(k)); // Set location for all the rooms
				k++;
			}
		}
		List<Monster> monsters = new ArrayList<Monster>(); // list of rooms
		
		// Use case - Player attacks monster
		Player p = new Player("The Lord",100,10);
		monsters.add(new Monster("Spider",20,2));
		monsters.add(new Monster("Monkey",40,3));
		
		monsters.get(1).setLocation(map.get(0));// put a monkey into room #1
		monsters.get(0).setLocation(map.get(1));// put a spider into room #2
		
		// add information for room #1
		rooms.get(0).addInformation("Restroom","a bathroom in a public building");// add name and description to a room
		rooms.get(0).addItem(new Inspectable ("Key#1","an old silver key with number 1 on it")); // Key #1
		
		// add information for room #2
		rooms.get(1).addInformation("Normal room","A small room, there is an apple on the table \r\n" + 
				"in the corner of the room.");// add name and description to a room
		rooms.get(1).addItem(new Inspectable ("Apple","a deciduous fruit")); // add an apple
		
		// add information for room #3
		rooms.get(2).addInformation("A small storage room", "It has spider web with some \r\n" + 
						"mosquito corpses that were still hanging on the \r\n" + 
						"wall. There's a spider on the ceiling directly above you. ");// add name and description to a room
		monsters.get(0).setLocation(rooms.get(2).getLocation());				
		
		System.out.println(rooms.get(0).inspect());
		
		p.addItem(new Inspectable ("Apple","a deciduous fruit")); // add an Apple into player inventory
		p.setLocation(map.get(0));  // Set location for player
		
		System.out.println(p.inspect()); // inspect player
		p.move("e");                   // player move to east
		System.out.println(p.inspect());
		
		boolean exit = false;
		Scanner reader = new Scanner(System.in);
		String command = "";
		System.out.print ("Please enter a command: ");
		while (!exit) {
			command = reader.next();
			if (command.toLowerCase().equals("quit")) {
				exit = true;
			}
			else if (command.toLowerCase().equals("battle")) { // "The Lord" attacks "Spider" 
				
				p.battle(findMonster(p,monsters));
				System.out.println("Player has "+p.getHP()+ "Health");
				//p.battle(monsters.get(0));
			}
			else if (command.toLowerCase().equals("search")) {
				System.out.println(p.currentRoom.inspect());
			}
			else if (command.toLowerCase().equals("help")) {
				help();
			}
			else if(command.toLowerCase().equals("west") ||command.toLowerCase().equals("w")) {
				p.move("w");
				p.setRoom(getCurrentRoom(p, rooms));
			}
			else if(command.toLowerCase().equals("east") ||command.toLowerCase().equals("e")) {
				p.move("e");
				p.setRoom(getCurrentRoom(p, rooms));
			}
			else if(command.toLowerCase().equals("north") ||command.toLowerCase().equals("n")) {
				p.move("n");
				p.setRoom(getCurrentRoom(p, rooms));
			}
			else if(command.toLowerCase().equals("south") ||command.toLowerCase().equals("s")) {
				p.move("s");
				p.setRoom(getCurrentRoom(p, rooms));
			}
			else if(command.toLowerCase().equals("inspect"))
			{
				System.out.println(p.inspect());
				
			}else if (command.toLowerCase().substring(0,5).equals("south")){}
			else{
				
			
				System.out.println("unknown command");
			}
		}
		reader.close();
	}
	
	public void initializeGame() {
		//Whoops there should be something here
	}
	public static Room getCurrentRoom(Character c,List<Room> r) {
		for (int i =0; i< maxRooms; i++) {
			if(r.get(i).getLocation()==c.getLocation()) {
				return r.get(i);
			}			
		}		
		return null;
	}
	public static Character findMonster(Player p,List<Monster> monsters) {
		for(Monster m : monsters) {
			if (p.getLocation()==m.getLocation()) {
				return m;
			}
		}
		return null;
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
