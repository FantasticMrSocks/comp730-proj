
public class locationController {
	private Location model;
	private locationView view;
	
	public locationController(Location model, locationView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setLocationName(String name) {
		model.setName(name);
	}
	
	public String getLocationName() {
		return model.getName();
	}
	
	public void setLocationLocNo(String locNo) {
		model.setLocNo(locNo);
	}
	
	public String getLocationLocNo() {
		return model.getLocNo();
	}
	
	public void updateView() {
		view.printLocationDetails(model.getName(), model.getLocNo());
	}
}
