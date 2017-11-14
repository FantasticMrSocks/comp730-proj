import java.util.Scanner;

public class game {
	public static void main(String[] args) {
		// Use case - Player attacks monster
		Player p = new Player("The Lord",100,10);
		Monster m = new Monster("Spider",50,5);		
		p.battle(m);
		boolean exit = false;
		Scanner reader = new Scanner(System.in);
		String command = "";
		while (!exit) {
			command = reader.next();
			if (command.equals("quit")) {
				exit = true;
			}
			else {
				System.out.println("unknown command");
			}
		}
		

	}
}
