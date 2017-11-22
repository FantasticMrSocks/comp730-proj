import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class game {
	
	public static void main(String[] args) {
		Map<String,MyCoord> multiplePoints = new HashMap<String,MyCoord>();
		multiplePoints.put("point1", new MyCoord(10, 20));
		multiplePoints.put("point2", new MyCoord(20, 40));
		
		MyCoord coord=multiplePoints.get("point1");
		System.out.println(coord.getX() + " : "+coord.getY());
		
		// Use case - Player attacks monster
		Player p = new Player("The Lord",100,10);
		Monster m = new Monster("Spider",50,5);			
		p.addItemToInv("bacon"); // related to inventory
		p.printInv(); // related to inventory
		p.removeItemFromInv("bacon"); // related to inventory
		p.printInv(); // related to inventory
		
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		rooms.add(new Room());
		rooms.add(new Room());
		rooms.get(0).addExit(new Exit(rooms.get(1), "east"));
		rooms.get(1).addExit(new Exit(rooms.get(0), "west"));
		p.currentRoom = rooms.get(0);
		
		boolean exit = false;
		Scanner reader = new Scanner(System.in);
		String command = "";
		System.out.print ("Please enter a command: ");
		while (!exit) {
			command = reader.next();
			if (command.equals("quit")) {
				exit = true;
			}else if (command.equals("battle")) { // "The Lord" attacks "Spider" 
				p.battle(m);
			}
			if (command.equals("search")) {
				System.out.println(p.currentRoom.inspect());
			}
			else if (command.equals("help")) {
				help();
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
