package health;

public class Main {
	
	public static void main( String args[] ) throws Exception {
	  
	/*	Database bob = new Database();
		 try {
				bob.connect();
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/
		
		
	/*	Exercise bench = new Exercise();
		bench.addSet(8, 145);
		bench.addSet(7, 144);
		bench.setName("Bench");
		System.out.println(bench.toString());
		bench.printSets();*/
		
		Database database = new Database();
		
		database.createTable();
		database.insertData(1,"Bench", 4, 3, 2);
		WorkoutCommandLine c = new WorkoutCommandLine();
		//c.commandLoop();
		}
		
}