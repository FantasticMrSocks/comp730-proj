import java.util.Scanner;

public class h5 {

	public static void main(String[] args) {
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
