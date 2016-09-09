package health;

import java.util.HashMap;


public class WorkoutController {
	
	WorkoutNumberGenerator exerciseID = new WorkoutNumberGenerator();
	HashMap<Integer,Exercise> workoutList = new HashMap<Integer, Exercise>();
	
	public void addExercise(String name, Integer[] sets){	
		 int id = exerciseID.generateID();
		 Exercise exercise = new Exercise(name,sets,id);
		 workoutList.put(id, exercise);
	}
	
	public void addExercise(String name){
		int id = exerciseID.generateID();
		 Exercise exercise = new Exercise(name,id);
		 workoutList.put(id, exercise);
	}
	
	public void addSet(int reps, int weight, int exerciseID){
		workoutList.get(exerciseID);
	}
	public Exercise getExercise(int exerciseID){
		Exercise red = workoutList.get(exerciseID);
		return red;
	}
}
