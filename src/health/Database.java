package health;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class Database {

    
  public void createTable(String tableName){

	  	String table = tableName;
	    Connection connection = null;
	    Statement stmt = null;
	    
		    try {
		      Class.forName("org.sqlite.JDBC");
		      connection = DriverManager.getConnection("jdbc:sqlite:" + table + ".db");  
		      System.out.println("Opened database successfully");
		
		      stmt = connection.createStatement();
		      String sql = "CREATE TABLE WORKOUT " +
		                   "(ID INT PRIMARY KEY     NOT NULL," +
		                   " DATE 			 INT	NOT NULL,"+	
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
      
      public void insertData(int id, String date, String name, int reps, int weight, String tableName) {
    	  
    	    Connection connection = null;
    	    
    	    
    	  try {
    	      Class.forName("org.sqlite.JDBC");
    	      connection = DriverManager.getConnection("jdbc:sqlite:" + tableName + ".db");
    	      connection.setAutoCommit(false);
    	      System.out.println("Opened database successfully");
    	      	  
            PreparedStatement statement = connection.prepareStatement(
              "INSERT INTO WORKOUT (ID,DATE,NAME,REPS,WEIGHT)" +
    		  "VALUES(?,?,?,?,?)");
            
          statement.setLong(1,id);
          statement.setString(2, date);
          statement.setString(3,name);
          statement.setLong(4, reps);
          statement.setLong(5, weight);
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
}
