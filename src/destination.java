import java.util.Scanner;

public class Destination {
	public static void main(String[] args) {
		int North;
		int South;
		int East;
		int West;		
		
		System.out.println("Enter your direction of travel");
		Scanner s1=new Scanner(System.in);
		int move=s1.nextInt();
		
		North = 1;
		South = 2;
		East = 3;
		West = 4; 
		
		if (move >= 1 && move<5) {
			System.out.println( "Lets Go");
			
		}
		
		else {
			System.out.println( "Invalid Selection");
			
		}
		
	}
	
	
}

