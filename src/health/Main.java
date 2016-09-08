package health;

public class Main {
	
	public static void main( String args[] ) {
	  
		Database bob = new Database();
		 try {
				bob.connect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}