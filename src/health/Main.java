package health;

public class Main {
	
	public static void main( String args[] ) {
	  
	/*	Database bob = new Database();
		 try {
				bob.connect();
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/
		
		
		Exercise bench = new Exercise();
		bench.addSet(8, 145);
		bench.addSet(7, 144);
		bench.setName("Bench");
		System.out.println(bench.toString());
		bench.printSets();
		}
		
}