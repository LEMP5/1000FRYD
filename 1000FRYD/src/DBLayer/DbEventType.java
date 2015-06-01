package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.EventType;
import ModelLayer.Job;

public class DbEventType {
	private  Connection con;
	private DbJob dbJ;
	private DbPartJob dbPJ;
	
    public DbEventType() {
      con = DbConnection.getInstance().getDBcon();
      dbJ = new DbJob();
      dbPJ = new DbPartJob();
    }
    
    public EventType findEventType(String name, boolean retriveAssociation)
    {   String wClause = "  name = '" + name + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    
    
    public EventType searchEventTypeLname(String attValue, boolean retriveAssociation)
    {
        String wClause = "lname = '" + attValue + "'";
        System.out.println("SearchEmployye " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }
   
     //insert a new EventType
    public int insertEventType(EventType evT) throws Exception
    {
       int rc = -1;
	   String query="INSERT INTO EventType(name)  VALUES('"+
	  		evT.getName() + "')";
                     

       System.out.println("insert : " + query);
      try{ // insert new EventType +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("EventType ikke oprettet");
          throw new Exception ("EventType is not inserted correct");
       }
       return(rc);
    }
	
	public int delete(String name)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM EventType WHERE name = '" +
				name + "'";
                System.out.println(query);
	  	try{ // delete from EventType
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in EventType db: "+ex);
   	        }
		return(rc);
	}
	
	private String buildQuery(String wClause)
	{
	    String query="SELECT name  FROM EventType";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private EventType buildEventType(ResultSet results)
      {   EventType evT = new EventType();
          try{ // the columns from the table emplayee  are used
                evT.setName(results.getString("name"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the EventType object");
         }
         return evT;
      }
	
	public EventType singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		EventType etObj = new EventType();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Event from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            etObj = buildEventType(results);
                            //assocaition is to be build
                            stmt.close();
                            if(retrieveAssociation)
                            {   
                            	String name = etObj.getName();
                                ArrayList<String> jobs = dbPJ.miscWhere(" type = '" + name + "'");
                                ArrayList<Job> jobList = new ArrayList<Job>();
                                for(int i = 0; i<jobs.size(); i++)
                                	jobList.add(dbJ.findJob(jobs.get(i)));
                                etObj.setJobList(jobList);
                                System.out.println("EventType is selected");
                            }
			}
                        else{ //no Event was found
                            etObj = null;
                        }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return etObj;
	}

}
