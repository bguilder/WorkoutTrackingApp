package health;

import java.util.Scanner;

public class WorkoutCommandLine {

	private static Scanner scanner = new Scanner(System.in);
	private static boolean exitProgram = false;
	private static boolean continueLoop = true;
	private static WorkoutController controller = new WorkoutController();
	
	public void commandLoop(){
	while(exitProgram == false){
		
		while(continueLoop == true){
		//get the exercise name
		System.out.println("What was the name of the exercise?");										
		String exerciseName = scanner.next();
		int workoutID = controller.addExercise(exerciseName);
		
		//how many sets for this particular exercise
		System.out.println("How many sets?");
		int sets = scanner.nextInt();
		
		
		//start for loop for sets
		for(int n=0; n < sets; n++){			
		System.out.println("Weight: ");
		int weight = scanner.nextInt();
		System.out.println("Reps: ");
		int reps = scanner.nextInt();
	    controller.addSet(reps,weight,workoutID);
		}
		
		System.out.println("Is there another exercise? (y/n)");
		String userResponse = scanner.next();
		if(userResponse.equalsIgnoreCase("y")){
			continueLoop = true;
			System.out.println();
		}
		else if(userResponse.equalsIgnoreCase("n")){
			exitProgram = true;
		}
		
		controller.printList();
		}
		
		
	
	}
	}
}
