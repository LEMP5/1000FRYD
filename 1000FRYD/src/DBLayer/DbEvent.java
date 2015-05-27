package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Event;
import ModelLayer.EventType;

public class DbEvent {
	private  Connection con;
	
    public DbEvent() {
      con = DbConnection.getInstance().getDBcon();
    }
    
    public ArrayList<Event> getAllEvents(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    public Event findEvent(String id, boolean retriveAssociation)
    {   String wClause = "  id = '" + id + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    public ArrayList<Event> getEventsOnDay(String date, boolean retriveAssociation)
    {
        String wClause = "date =" + date + "'";
        System.out.println("SearchEmployye " + wClause);
        return miscWhere(wClause, retriveAssociation);
    }
   
     //insert a new Event
    public int insertEvent(Event ev) throws Exception
    {  //call to get the next ssn number
        int nextID = GetMax.getMaxId("Select max(id) from Event");
        nextID = nextID + 1;
        System.out.println("next id = " +  nextID);
  
       int rc = -1;
	   String query="INSERT INTO Event(id, name, description, startHour, endHour, type)  VALUES('"+
			nextID  + "','"  +
		    ev.getName()  + "','"  +
		    ev.getDescription()  + "','"  +
		    ev.getStartHour()  + "','"  +
		    ev.getEndHour()  + "','"  +
            ev.getType().getName() + "')";
                     

       System.out.println("insert : " + query);
      try{ // insert new Event +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("Event ikke oprettet");
          throw new Exception ("Event is not inserted correct");
       }
       return(rc);
    }

	public int updateEvent(Event ev)
	{
		Event evObj  = ev;
		int rc=-1;

		String query="UPDATE Event SET "+
		 	  "name ='"+ evObj.getName()+"', "+
		 	  "description ='"+ evObj.getDescription()+"', "+
		 	  "startHour ='"+ evObj.getStartHour()+"', "+
		 	  "endHour ='"+ evObj.getEndHour()+"', "+
		          " WHERE id = '"+ evObj.getId() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Event
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//slut try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Event db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String id)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Event WHERE id = '" +
				id + "'";
                System.out.println(query);
	  	try{ // delete from Event
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Event db: "+ex);
   	        }
		return(rc);
	}
	
	//private methods
    //michWere is used whenever we want to select more than one Event
	
	 
	private ArrayList<Event> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<Event> list = new ArrayList<Event>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the Event from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
	     	 Event evObj = new Event();
		 evObj = buildEvent(results);	
                 list.add(evObj);	
		}//end while
                 stmt.close();     
                 if(retrieveAssociation)
                 {   //The EventType
                     for(Event evObj : list){
                        String type = evObj.getType().getName();
                        EventType evType = singleWhereType(" name = '" + type + "'",false);
                        evObj.setType(evType);
                        System.out.println("Supervisor is seleceted");
                       // here the department has to be selected as well
                     }
                 }//end if   
			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	//Singelwhere is used when we only select one Event 	
	private Event singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Event empObj = new Event();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Event from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            empObj = buildEvent(results);
                            //assocaition is to be build
                            stmt.close();
                            if(retrieveAssociation)
                            {   //The supervisor and department is to be build as well
                                String superssn = empObj.getSupervisor().getSsn();
                                Event superEmp = singleWhere(" ssn = '" + superssn + "'",false);
                                empObj.setSupervisor(superEmp);
                                System.out.println("Supervisor is seleceted");
                               // here the department has to be selected as well
                           
                           
                            }
			}
                        else{ //no Event was found
                            empObj = null;
                        }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return empObj;
	}
	
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT id, name, description, startHour, endHour  FROM Event";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Event object
	private Event buildEvent(ResultSet results)
      {   Event evObj = new Event();
          try{ // the columns from the table emplayee  are used
                evObj.setName(results.getString("name"));
                evObj.setDescription(results.getString("description"));
                evObj.setStartHour(results.getInt("startHour"));
                evObj.setEndHour(results.getInt("endHour"));
                evObj.setType(new EventType(results.getString("type")));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Event object");
         }
         return evObj;
      }
	private EventType buildEventType(ResultSet results)
    {   EventType evObj = new EventType();
        try{ // the columns from the table emplayee  are used
              evObj.setName(results.getString("name"));
              
        }
       catch(Exception e)
       {
           System.out.println("error in building the Event object");
       }
       return evObj;
    }
}
