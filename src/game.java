import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class game {
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
				
			Map <String,MyCoord> multiplePoints=new HashMap<String, MyCoord>();
			multiplePoints.put("point1", new MyCoord(10, 20));
			multiplePoints.put("point2", new MyCoord(20, 40));

			MyCoord coord=multiplePoints.get("point1");
			System.out.println(coord.getX() + " : "+coord.getY());

		}

		
}