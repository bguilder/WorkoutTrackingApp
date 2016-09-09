package health;

import java.util.Scanner;

public class WorkoutCommandLine {

	private static Scanner scanner = new Scanner(System.in);
	private static boolean exitProgram = false;
	@SuppressWarnings("unused")
	private static WorkoutController controller = new WorkoutController();
	
	public void commandLoop(){
	while(exitProgram == false){
		
		System.out.println("What was the name of the exercise?");										
		String exerciseName = scanner.nextLine();
		//controller.addExercise(exerciseName);
		
		System.out.println("How many sets?");
		int sets = scanner.nextInt();
		for(int n=0; n < sets; n++){			
		System.out.println("Weight: ");
		int weight = scanner.nextInt();
		System.out.println("Reps: ");
		int reps = scanner.nextInt();
	    controller.addSet(reps,weight);
		}
		
		controller.addExercise(exerciseName,);
	
	}
	}
}
