package health;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Database {

    
  public void createTable(){

	    Connection connection = null;
	    Statement stmt = null;
	    
		    try {
		      Class.forName("org.sqlite.JDBC");
		      connection = DriverManager.getConnection("jdbc:sqlite:workout.db");  
		      System.out.println("Opened database successfully");
		
		      stmt = connection.createStatement();
		      String sql = "CREATE TABLE WORKOUT " +
		                   "(ID INT PRIMARY KEY     NOT NULL," +
		                   " NAME           TEXT    NOT NULL, " + 
		                   " REPS        	 INT     NOT NULL, " + 
		                   " WEIGHT          INT     NOT NULL )"; 
		      stmt.executeUpdate(sql);
		      stmt.close();
		      connection.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    
		    System.out.println("Table created successfully");
		    
  }
      
      public void insertData(int id, String name, int reps, int weight) {
    	  
    	    Connection connection = null;
    	    
    	  try {
    	      Class.forName("org.sqlite.JDBC");
    	      connection = DriverManager.getConnection("jdbc:sqlite:workout.db");
    	      connection.setAutoCommit(false);
    	      System.out.println("Opened database successfully");
    	      	  
            PreparedStatement statement = connection.prepareStatement(
              "INSERT INTO WORKOUT (ID,NAME,REPS,WEIGHT)" +
    		  "VALUES(?,?,?,?)");
          statement.setLong(1,id);
          statement.setString(2,name);
          statement.setLong(3, reps);
          statement.setLong(4, weight);
          statement.executeUpdate();

          connection.commit();
          statement.close();
          connection.close();
    	  
      } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
    
    System.out.println("Records created successfully");
    
  }
      
  /*    public void updateData()throws Exception{
    	  stmt = connection.createStatement();
          String sql = "UPDATE WORKOUT set NAME = 'squat' where ID=1;";
          stmt.executeUpdate(sql);
          connection.commit();
    	  
      }*/
}
