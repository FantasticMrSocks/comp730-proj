
public class LocationPattern {
	public static void main(String[] args) {
		// get location 
		Location model = retriveLocationFromDatabase();
		
		//create a view : to display 
		locationView view = new locationView();
		
		locationController controller = new locationController(model, view);
		
		controller.updateView();
		
		//update model data
		//controller.setLocationName("Start");
		
		controller.updateView();
		
	}

	//this is a test to see if it works 
	private static Location retriveLocationFromDatabase() {
		Location Location = new Location();
		Location.setName("Room2");
		Location.setLocNo("2");
		return Location;
		
	}
}
