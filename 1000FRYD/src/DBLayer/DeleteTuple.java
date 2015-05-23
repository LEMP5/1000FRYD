package DBLayer;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ModelLayer.Volunteer;


public class DeleteTuple extends Thread {
	private Connection connection;
	private String email;
	
    public DeleteTuple(String email)
    {
    	super("Connection");
    	connection = DbConnection.getInstance().getDBcon();
        this.email = email;
    }

    public void run() {
    	try {
			Statement stmt = connection.createStatement();
		 	stmt.setQueryTimeout(5);
		 	ResultSet results = stmt.executeQuery("SELECT * FROM People WHERE email = '"+email+"'");
		 	while(results.next()) {
		 		if(results.getString("bartokens") == null && results.getString("signUpDate") == null) {
		 			System.out.println("zzz   zzz");
			 		deleteSQL();
			 	}
		 	}
	       	stmt.close();
		} catch (Exception e) {
			System.out.println("run - Query exception: "+e);
		}
    }
    
    private void deleteSQL() throws Exception {
    	int rc = -1;
		try {
        	Statement stmt = connection.createStatement();
        	stmt.setQueryTimeout(5);
        	rc = stmt.executeUpdate("DELETE People WHERE email = '"+email+"'");
        	stmt.close();
        }
        catch(SQLException e) {
        	throw new Exception(""+e);
        }
    }
}
