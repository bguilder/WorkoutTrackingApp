package health;

public class Exercise {

	String name;
	int reps;
	int weight;
	int[] sets = {reps,weight}; //need to keep the reps and weight of each set together
	String description;

	public Exercise(){
	
	}
	
	public Exercise(String name, int weight, int reps, int[] sets, String description) {
		this.weight = weight;
		this.name = name;
		this.reps = reps;
		this.sets = sets;
		this.description = description;
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
	public int[] getSets() {
		return sets;
	}
	public void setSets(int[] sets) {
		this.sets = sets;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int[] fillSet(int reps, int weight){
		int [] sets = {reps,weight};
		return sets; 
	}

	@Override
	public String toString(){
		return "Exercise Name: " + getName() + "\nReps: " + getReps() + "\nSets: " + getSets() + "\nDescription" + getDescription();
	}
	
}
