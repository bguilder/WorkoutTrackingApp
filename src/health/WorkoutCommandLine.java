package health;

import java.util.Scanner;

public class WorkoutCommandLine {

	private static Scanner scanner = new Scanner(System.in);
	private static boolean exitProgram = false;
	@SuppressWarnings("unused")
	private static WorkoutController controller;
	
	public void commandLoop(){
	while(exitProgram == false){
		
		System.out.println("What workout did u do?\n"
							+ "1. Chest\n"
							+ "2. Back\n"
							+ "3. Arms\n"
							+ "4. Legs\n"
							+ "5. Cardio\n");
						
		int userSelection = scanner.nextInt();
		
		switch(userSelection){
		
		case 1:  
			System.out.println("What workouts did you do?");
			
			break;
		case 2:  
			System.out.println("What workouts did you poo?");
			
			break;
		
		}	
	}
	}
}
