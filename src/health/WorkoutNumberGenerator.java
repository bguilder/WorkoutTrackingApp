package health;

public class WorkoutNumberGenerator {

	private int lastIDUsed = 1;
	
	public int generateID(){
		int id = lastIDUsed;
		lastIDUsed++;
		return id;
	}
}
