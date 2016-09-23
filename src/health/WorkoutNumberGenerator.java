package health;

public class WorkoutNumberGenerator {

	private int lastIDUsed;
	
	public int generateID(){
		int id = lastIDUsed;
		lastIDUsed++;
		return id;
	}
	
	public void setLastIDUsed(int lastID){
		this.lastIDUsed = lastID;
		lastIDUsed++;
		
	}
}
