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
		rooms.get(8).addHallway("climbup", rooms.get(9));
		rooms.get(9).addHallway("climbup", rooms.get(6));
		
		rooms.get(6).addHallway("southwest", rooms.get(4));
		rooms.get(6).addHallway("southeast", rooms.get(5));	
		rooms.get(5).addHallway("southwest", rooms.get(4));
		rooms.get(4).addHallway("gosouth", rooms.get(3));
		rooms.get(3).addHallway("southeast", rooms.get(2));
		rooms.get(2).addHallway("gosouth", rooms.get(1));
		rooms.get(1).addHallway("southwest", rooms.get(0));
		rooms.get(7).addHallway("southwest", rooms.get(1));
		rooms.get(8).addHallway("gosouth", rooms.get(7));
		rooms.get(9).addHallway("climbdown", rooms.get(8));
		rooms.get(6).addHallway("east", rooms.get(9));
		
		rooms.get(0).addInformation("Restroom","A bathroom in a public building. I should get out of here and go explore. To the east there is a door leading outside. As the saying goes, 'There's nothing to see here.'");// add name and description to a room
		rooms.get(1).addInformation("Field", "A green field with nothing in it. To the southwest is the restroom, to the north is a door leading inside, to the east is the Garden.");// add name and description to a room
		rooms.get(2).addInformation("Storage", "An old dusty storage room with a shiny object. To the west is the kitchen, we can also gosouth to go back outside.");// add name and description to a room
		rooms.get(3).addInformation("Kitchen", "The kitchen, what messey people eat in this place. To the north is an office and to the southeast is the Storage closet."); // add name and description to a room
		rooms.get(4).addInformation("Office", "There are many desks and chairs here. We can move northeast to the Auditorium or east to the Meeting Room. We also can gosouth back to the kitchen.");// add name and description to a room
		rooms.get(5).addInformation("Meeting Room", "This is a meeting room, there is one large desk, many chairs, and a file drawer. The Auditorium is to the northwest and the Office to the southwest.");//add name and description to a room
		rooms.get(6).addInformation("Auditorium", "The auditorium is a huge space, something big with six legs is blocking the exit. We have the Office to the southwest and the Meeting Room to the southeast, and the Fire Ladder outside the window to the east");//add description to a room
		rooms.get(7).addInformation("Garden", "This is the garden, to the north is a fire escape, to the southwest is the field");
		rooms.get(8).addInformation("Fire Escape", "This is the outside Fire Escape, we can climbup the ladder in front of us or gosouth back to the Garden");
		rooms.get(9).addInformation("Fire Ladder", "This is the Fire Ladder, we can climbup and into the Auditorium or climbdown to the bottom of the Fire Escape");
		
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
			else if(command.equals("north")) {
				p.move("north");
			}
			else if(command.equals("northeast")) {
				p.move("northeast");
			}
			else if(command.equals("northwest")) {
				p.move("northwest");
			}
			else if(command.equals("southeast")) {
				p.move("southeast");
			}
			else if(command.equals("southwest")) {
				p.move("southwest");
			}
			else if(command.equals("gosouth")) {
				p.move("gosouth");
			}
			else if(command.equals("climbup")) {
				p.move("climbup");
			}
			else if(command.equals("climbdown")) {
				p.move("climbdown");
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
