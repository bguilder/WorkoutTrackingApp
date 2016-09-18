package health;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Database {

	Connection connection = null;
    Statement stmt = null;
    
  public void connect(){
	
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:workout.db");
      connection.setAutoCommit(false);
      System.out.println("Opened database successfully");
    } 
    catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
      }
  }
  public void createTable(){

		 Connection c = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:workout.db");
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Opened database successfully");
		  
			
			
			
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:workout.db");
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      String sql = "CREATE TABLE WORKOUT " +
		                   "(ID INT PRIMARY KEY     NOT NULL," +
		                   " NAME           TEXT    NOT NULL, " + 
		                   " SETS            INT     NOT NULL, " + 
		                   " REPS        	 INT     NOT NULL, " + 
		                   " WEIGHT          INT     NOT NULL )"; 
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table created successfully");
  }
      
      public void insertData(int id, String name, int sets, int reps, int weight) throws Exception{
    	  try {
    	      Class.forName("org.sqlite.JDBC");
    	      connection = DriverManager.getConnection("jdbc:sqlite:workout.db");
    	      connection.setAutoCommit(false);
    	      System.out.println("Opened database successfully");
    	    } 
    	    catch ( Exception e ) {
    	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	        System.exit(0);
    	      }
    	  
      
      PreparedStatement statement = connection.prepareStatement(
              "INSERT INTO WORKOUT (ID,NAME,SETS,REPS,WEIGHT)" +
    		  "VALUES(?,?,?,?,?)");
          statement.setLong(1,3);
          statement.setString(2,name);
          statement.setLong(3, sets);
          statement.setLong(4, reps);
          statement.setLong(5, weight);
          statement.executeUpdate();

          connection.commit();
          statement.close();
      //    connection.close();
    
    System.out.println("Records created successfully");
  }
      public void updateData()throws Exception{
    	  stmt = connection.createStatement();
          String sql = "UPDATE WORKOUT set NAME = 'squat' where ID=1;";
          stmt.executeUpdate(sql);
          connection.commit();
    	  
    	  
    	  
      }
}
