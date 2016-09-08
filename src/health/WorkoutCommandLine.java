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
		System.out.println("How many sets?");
		int sets = scanner.nextInt();
		for(int n=1; n <= sets; n++){			
		System.out.println("Weight of" + n + "set");
		int weight = scanner.nextInt();
		System.out.println("Reps of" + n + "set");
		int reps = scanner.nextInt();
		controller.setSets(reps, weight);
		}
		
	
	}
	}
}
