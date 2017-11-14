import java.util.Scanner;

public class game {
	public static void main(String[] args) {
		// Use case - Player attacks monster
		Player p = new Player("The Lord",100,10);
		Monster m = new Monster("Spider",50,5);			
		
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
				//search room
			}
			else {
				System.out.println("unknown command");
			}
		}
	}
}
