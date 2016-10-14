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
	
	public String listToString(){
		StringBuilder string = new StringBuilder();
		for (Exercise exercise : workoutList.values()) {
		    string.append(exercise.toString() + "\n");
		}
		
		return string.toString();
	}

	public void toDatabase(String tableName){
		for(Exercise exercise : workoutList.values()){
			database.insertData(exercise.getExerciseID(), exercise.getDate(), exercise.getName(), exercise.getReps(), exercise.getWeight(), tableName);
		}
	}

	public void createTable(String table){
		String tableName = table;
		database.createTable(tableName);
	}
	public void setLastUsedID(int lastUsedID){
		numGenerator.setLastIDUsed(lastUsedID);
	}
}
