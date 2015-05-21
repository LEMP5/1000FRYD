package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Day;

public class DbDay {
	private  Connection con;
    /** Creates a new instance of DBEmployee */
    public DbDay() {
      con = DbConnection.getInstance().getDBcon();
    }
    
    public ArrayList<Day> getAllDays(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    public Day findDay(String date, boolean retriveAssociation)
    {   String wClause = "  date = '" + date + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    public int insertDay(Day day) throws Exception
    {   
  
       int rc = -1;
	   String query="INSERT INTO day(date, dayOfWeek)  VALUES('"+
	  		day.getDate()  + "','"  +
		    day.getDayOfWeek()  + "')";
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
		Day day = new Day();
                
	        String query =  buildQuery(wClause);
		try{ 
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            empObj = buildEmployee(results);
                            //assocaition is to be build
                            stmt.close();
                            if(retrieveAssociation)
                            {   //The supervisor and department is to be build as well
                                String superssn = empObj.getSupervisor().getSsn();
                                Employee superEmp = singleWhere(" ssn = '" + superssn + "'",false);
                                empObj.setSupervisor(superEmp);
                                System.out.println("Supervisor is seleceted");
                               // here the department has to be selected as well
                           
                           
                            }
			}
                        else{ //no employee was found
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
	    String query="SELECT fname, minit,lname,ssn, address, bdate,sex, salary, superssn,dno  FROM employee";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an employee object
	private Employee buildEmployee(ResultSet results)
      {   Employee empObj = new Employee();
          try{ // the columns from the table emplayee  are used
                empObj.setFname(results.getString("fname"));
                empObj.setMinit(results.getString("minit"));
                empObj.setLname(results.getString("lname"));
                empObj.setSsn(results.getString("ssn"));
                empObj.setBdate(results.getString("bdate"));
                empObj.setAddress(results.getString("address"));
                empObj.setSex(results.getString("sex"));
                empObj.setSalary(results.getDouble("salary"));
                empObj.setSupervisor(new Employee(results.getString("superssn")));
                empObj.setDepartment(new Department(results.getInt("dno")));
          }
         catch(Exception e)
         {
             System.out.println("error in building the employee object");
         }
         return empObj;
      }

	@Override
	public Employee searchEmployeeSsn(String ssn, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

}
