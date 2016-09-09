package health;

import java.util.ArrayList;

public class Workout {

	ArrayList<Exercise> workoutList = new ArrayList<Exercise>();
	
	public Workout(){
		
	}
	
	public Workout(ArrayList<Exercise> workoutList){
		this.workoutList = workoutList;
	}
	
	public void addExercise(String name, ArrayList<Integer[]>sets){		
		// Exercise exercise = new Exercise(name,sets);
	//	 workoutList.add(exercise);
	}
	
	
}
