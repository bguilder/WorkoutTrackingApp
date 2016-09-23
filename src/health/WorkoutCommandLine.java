package health;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;


public class WorkoutCommandLine {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean exitProgram = false;
	private static WorkoutController controller = new WorkoutController();
	
	
	public void commandLoop(){
		
	while(exitProgram == false){
		
			
		System.out.println("1. Add Exercises");
		System.out.println("2. View current exercises");
		System.out.println("3. Add List to Database");
		int userChoice = scanner.nextInt();
		if(userChoice==1){
			addExercise();
		}
		else if(userChoice==2){
			controller.printList();
		}
		else if(userChoice==3){
			controller.toDatabase();
		}
			
		}//ends exitProgram while loop
	}//ends method comomandLoop

	
	public void addExercise(){
		
		//get the last exerciseID from the database
		System.out.println("Enter the last exerciseID from the database");
		int lastUsedID = scanner.nextInt();
		controller.setLastUsedID(lastUsedID);
		
		//get the date of the exercise		
		String date = getDate();
		
		//get the exercise name
		System.out.println("What was the name of the exercise?");										
		String exerciseName = scanner.next();
		
		//how many sets for this particular exercise
		System.out.println("How many sets?");
		int sets = scanner.nextInt();
			
		//start for loop for sets
		for(int n=0; n < sets; n++){			
		System.out.println("Weight: ");
		int weight = scanner.nextInt();
		System.out.println("Reps: ");
		int reps = scanner.nextInt();
		//create a unique workoutID and workout object for this set
		int workoutID = controller.createExercise(exerciseName);
		controller.addExerciseInfo(workoutID, date, reps, weight);
		}
		

	}
	public String getDate(){
		
		String userResponse;	
		DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
	    Date today = new Date();
		
		System.out.print("Was the workout today?(y/n)");
		userResponse = scanner.next();
		
		if(userResponse.equalsIgnoreCase("y")){
    	    userResponse = date.format(today);
    	    return userResponse;
		}
		else if(userResponse.equalsIgnoreCase("n")){
			System.out.print("Enter the date: (MM-dd-yyyy)");
			userResponse = scanner.next();
			return userResponse;
		}
		else{
			System.out.print("Something is wrong.");
			return null;
		}	
	}
	
	
	
}//end class
