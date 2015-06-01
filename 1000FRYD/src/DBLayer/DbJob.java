package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Job;

public class DbJob {
	private  Connection con;
    
    public DbJob() {
      con = DbConnection.getInstance().getDBcon();
    }
    
    public Job findJob(String name)
    {   String wClause = "  name = '" + name + "'";
        return singleWhere(wClause);
    }
    public Job searchJob(String name)
    {   String wClause = "  name = '" + name + "'";
        return singleWhere(wClause);
    }
    
    public int insertJob(Job job) throws Exception
    {    
       int rc = -1;
	   String query="INSERT INTO Job(name, bartokens, room, duration)  VALUES('"+
	  		job.getName()  + "','"  +
		    job.getBartokens()  + "','"  +
		    job.getRoom() + "','" +
            job.getDuration() + "')";
                     

       System.out.println("insert : " + query);
      try{ // insert new Job +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("Job ikke oprettet");
          throw new Exception ("Job is not inserted correct");
       }
       return(rc);
    }

	public int updateJob(Job job)
	{
		Job jObj  = job;
		int rc=-1;

		String query="UPDATE Job SET " +
		 	  "bartokens ='"+ jObj.getBartokens() + "', " +
              "room ='"+ jObj.getRoom() + "', " +
              "duration ='"+ jObj.getDuration() + "' " +
		      " WHERE name = '"+ jObj.getName() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Job
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//slut try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Job db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String name)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Job WHERE name = '" +
				name + "'";
                System.out.println(query);
	  	try{ // delete from Job
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Job db: "+ex);
   	        }
		return(rc);
	}
	 	
	public Job singleWhere(String wClause)
	{
		ResultSet results;
		Job jObj = new Job();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            jObj = buildJob(results);
                            stmt.close();
			}
                        else{ 
                            jObj = null;
                        }
		}	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return jObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query=" Select name, bartokens, room, duration FROM Job";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Job object
	private Job buildJob(ResultSet results)
      {   Job jObj = new Job();
          try{ // the columns from the table emplayee  are used
                jObj.setName(results.getString("name"));
                jObj.setBartokens(Integer.parseInt(results.getString("bartokens")));
                jObj.setRoom(results.getString("room"));
                jObj.setDuration(Integer.parseInt(results.getString("duration")));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Job object");
         }
         return jObj;
      }
}
