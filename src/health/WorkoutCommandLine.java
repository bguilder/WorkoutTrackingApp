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
	      mainFrame = new JFrame("Brian's Workout App");
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
	      JButton printList = new JButton("View List");
	      JButton toDatabase = new JButton("Add to Database");

	      addExercise.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            addExercise();
	         }          
	      });

	      printList.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JOptionPane.showMessageDialog(mainFrame, controller.listToString());
	         }
	      });

	      toDatabase.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 toDatabase();
	         }
	      });


	      
	      controlPanel.add(addExercise);
	      controlPanel.add(printList);
	      controlPanel.add(toDatabase);       
	      
	      mainFrame.setVisible(true);  
	   }

	
	public void addExercise(){
		
		
		//get the date of the exercise		
		String date = getDate();
		
		//get the exercise name
		String exerciseName = JOptionPane.showInputDialog("What was the name of the exercise?");
		
		//how many sets for this particular exercise
		String temp1 = JOptionPane.showInputDialog("How many sets?");
		int sets = Integer.parseInt(temp1);
			
		//start for loop for sets
		for(int n=1; n <= sets; n++){			
		String temp2 = JOptionPane.showInputDialog("Weight for set #" + n);
		int weight = Integer.parseInt(temp2);
		
		String temp3 = JOptionPane.showInputDialog("Reps for set #" + n);
		int reps = Integer.parseInt(temp3);
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
	
	public void toDatabase(){
		String userResponse = JOptionPane.showInputDialog("Are you a new user? (y/n)");

		if(userResponse.equalsIgnoreCase("y")){
			String tableName = JOptionPane.showInputDialog("Enter your table name(minus .db): ");
			controller.toDatabase(tableName);
		}
		else if(userResponse.equalsIgnoreCase("n")){
		String tableName = JOptionPane.showInputDialog("Enter a name for your table:");
			controller.createTable(tableName);
			controller.toDatabase(tableName);
		}
	}
	
	
}//end class
