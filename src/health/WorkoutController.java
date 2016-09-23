package health;

import java.util.HashMap;


public class WorkoutController {
	
	private Database database = new Database();
	private WorkoutNumberGenerator numGenerator = new WorkoutNumberGenerator();
	private HashMap<Integer,Exercise> workoutList = new HashMap<Integer, Exercise>();
	
	public void addExerciseInfo(int exerciseID, String date, int reps, int weight){	
	   workoutList.get(exerciseID).setReps(reps);
	   workoutList.get(exerciseID).setWeight(weight);
	   workoutList.get(exerciseID).setDate(date);

	}
	
	public int createExercise(String name){
		int id = numGenerator.generateID();
		 Exercise exercise = new Exercise(id,name);
		 workoutList.put(id, exercise);
		 return id;
	}
	
	public void printList(){
		for (Exercise exercise : workoutList.values()) {
		    System.out.println(exercise.toString());
		}
	}

	public void toDatabase(){
		for(Exercise exercise : workoutList.values()){
			database.insertData(exercise.getExerciseID(), exercise.getDate(), exercise.getName(), exercise.getReps(), exercise.getWeight());
		}
	}
	public void addExerciseToDB(int exerciseID, String date, String exerciseName, int reps, int weight) throws Exception{
		database.insertData(exerciseID, date, exerciseName, reps, weight);
	}
	public void createTable(){
		database.createTable();
	}
	public void setLastUsedID(int lastUsedID){
		numGenerator.setLastIDUsed(lastUsedID);
	}
}
