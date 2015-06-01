package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Day;
import ModelLayer.Event;
import ModelLayer.Job;

public class DbDay {
	private  Connection con;
	private DbEvent dbEvent;
    /** Creates a new instance of DBEmployee */
    public DbDay() {
      con = DbConnection.getInstance().getDBcon();
    }
    public Day getDay(String date, String dayOfWeek){
    	Day dayObj = findDay(date, false);
    	if(dayObj== null)
			try {
				insertDay(date, dayOfWeek);
				return findDay(date, false);
			} catch (Exception e) {
				System.out.println("Error while creating Day.");
			}
    	return dayObj;
    	
    }
    public Day findDay(String date, boolean retriveAssociation)
    {   String wClause = "  date = '" + date + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    public int insertDay(String date, String dayOfWeek) throws Exception
    {   
  
       int rc = -1;
	   String query="INSERT INTO day(date, dayOfWeek)  VALUES('"+
	  		date  + "','"  +
		    dayOfWeek  + "')";
      try{
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          throw new Exception ("Employee is not inserted correct");
       }
       return(rc);
    }
	
	public int delete(String date)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM day WHERE date < '" +
				date + "'";
	  	try{ 
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in employee db: "+ex);
   	        }
		return(rc);
	}

 	
	private Day singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Day dayObj = new Day();
                
	        String query =  buildQuery(wClause);
		try{ 
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            dayObj = buildDay(results);
                            //assocaition is to be build
                            stmt.close();
                            if(retrieveAssociation)
                            {
                            	String date = dayObj.getDate();
                                ArrayList<Event> eventList = dbEvent.miscWhere(" date = '" + date + "'", true);
                                dayObj.setEventList(eventList);
                                System.out.println("Day is selected");
                            }
			}
                        else{ //no employee was found
                            dayObj = null;
                        }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return dayObj;
	}
	private String buildQuery(String wClause)
	{
	    String query="SELECT date, dayOfWeek FROM day";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	private Day buildDay(ResultSet results)
      {   Day dayObj = new Day();
          try{
                dayObj.setDate(results.getString("date"));
                dayObj.setDayOfWeek(results.getString("dayOfWeek"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the day object");
         }
         return dayObj;
      }

}
