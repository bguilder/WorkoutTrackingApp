package health;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class WorkoutCommandLine extends JFrame {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean exitProgram = false;
	private static WorkoutController controller = new WorkoutController();
		
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	public void prepareGUI(){
	      mainFrame = new JFrame("BGuildz Workout App");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);    

	      statusLabel.setSize(350,100);

	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	public void showButtonDemo(){

		  prepareGUI();
	      headerLabel.setText("Main Menu"); 


	      JButton addExercise = new JButton("Add Exercise");        
	      JButton printList = new JButton("Print List");
	      JButton toDatabase = new JButton("Add to Database");
	     // cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);   

	      addExercise.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            addExercise();
	         }          
	      });

	      printList.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            controller.printList();
	         }
	      });

	      toDatabase.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            controller.toDatabase();
	         }
	      });

	      controlPanel.add(addExercise);
	      controlPanel.add(printList);
	      controlPanel.add(toDatabase);       

	      mainFrame.setVisible(true);  
	   }

	
	public void commandLoop(){
		
		prepareGUI();
		
	while(exitProgram == false){
		
		
	/*    JButton addExercise = new JButton("Add Exercise");  
	    addExercise.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	           addExercise();
	         }          
	      });*/

		String str1 = JOptionPane.showInputDialog("1. Add Exercises\n" + "2. View current exercises\n" + "3. Add List to Database");
		int userChoice = Integer.parseInt(str1);
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
		String id = JOptionPane.showInputDialog("Enter the last exerciseID from the database");
		int lastUsedID = Integer.parseInt(id);
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
		
		userResponse = JOptionPane.showInputDialog("Was the workout today?(y/n)");
		
		if(userResponse.equalsIgnoreCase("y")){
    	    userResponse = date.format(today);
    	    return userResponse;
		}
		else if(userResponse.equalsIgnoreCase("n")){
			userResponse = JOptionPane.showInputDialog("Enter the date: (MM-dd-yyyy)");
			return userResponse;
		}
		else{
			System.out.print("Something is wrong.");
			return null;
		}	
	}
	
	
	
}//end class
