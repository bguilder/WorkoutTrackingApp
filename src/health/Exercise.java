package health;

public class Exercise {

	private String name;
	private int reps;
	private int weight;
	private int exerciseID;
	private String date;
	
	public Exercise(){	
	}
	
	public Exercise(int exerciseID, String name, int reps, int weight) {
		this.name = name;
		this.reps = reps;
		this.weight = weight;
		this.exerciseID = exerciseID;
	}
	
	public Exercise(int exerciseID, String name){
		this.name = name;
		this.exerciseID = exerciseID;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public int getExerciseID(){
		return exerciseID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Exercise ID: " + exerciseID + " Date: " + date + " Name: " + name + " Reps: " + reps + " Weight: " + weight;
	}
	
	
}
