package DBLayer;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class DbPeople {
	private Connection connection;
	
	public DbPeople() {
		connection = DbConnection.getInstance().getDBcon();
	}
	
	public People[] getPerson(String email) {
		People[] p = new People[3];//{"Volunteer", "Member", "Person"};
		for(int i = 0; i < p.length; i++) {
			try {
				People pp = resultsSQLPeople(email);
				if(pp instanceof Volunteer && p[0] == null) {
					p[0] = pp;
					creteExperienceSQL((Volunteer) p[i]);
				}
				else if(pp instanceof Member && p[1] == null)
					p[1] = pp;
				else if(pp instanceof Person && p[2] == null)
					p[2] = pp;
			}
			catch (Exception e) {}
		}
		return p;
	}
	
	public People resultsSQLPeople(String email) {
		People people = null;
		try {
			Statement stmt = connection.createStatement();
		 	stmt.setQueryTimeout(5);
		 	ResultSet results = stmt.executeQuery("SELECT * FROM People WHERE email = '"+email+"'");
		 	while(results.next()) {
		 		people = cretePersonSQL(results);
		 	}
	       	stmt.close();
		} catch (Exception e) {
			System.out.println("resultsSQL - Query exception: "+e);
		}
		return people;
	}
	
	private People cretePersonSQL(ResultSet results) {
        People p = null;//System.out.println("zzz");
        try {
        	String email = results.getString("email");////////////////////////////////////////////Person
        	String telephoneNo = results.getString("telephoneNo");
        	String name = results.getString("name");
        	String surname = results.getString("surname");
        	String language = results.getString("language");
        	String password = results.getString("password");
        	boolean privilege = false; if(results.getString("administrator").equals("1")){privilege = true;}
        	if(results.getString("bartokens") != null) {
        		int bartokens = Integer.parseInt(results.getString("bartokens"));///////////////////////////////////////////Volunteer
        		boolean available = true; if(results.getString("available").equals("0")){available = false;}
        		boolean paid = false; if(results.getString("paid").equals("1")){paid = true;}
        		p = new Volunteer(telephoneNo, name, surname, language, password, privilege,email,
        				bartokens, available, paid);
        	}
        	else if(results.getString("signUpDate") != null) {
        		String signUpDate = results.getString("signUpDate");///////////////////////////////////////Member
        		String roomReserved = results.getString("roomReserved");
        		String periodReserved = results.getString("periodReserved");
        		p = new Member(telephoneNo, name, surname, language, password, privilege, email,
        				signUpDate, roomReserved, periodReserved);
        	}
        	else
        		p = new Person(telephoneNo, name, surname, language, password, privilege, email);
        }
        catch (NumberFormatException | SQLException e) {
            System.out.println("cretePersonSQL - Query exception: "+e);
        }
        return p;
    }
	
	public void createPerson(People peopleObj) {//to do
		int rc = -1;//System.out.println("");
        String queryInsert = "INSERT INTO People (telephoneNo, name, surname, language, email, administrator";
        String queryValues = " VALUES ('"+peopleObj.getTelephoneNo()+"','"+peopleObj.getName()+"','"+peopleObj.getSurname()+"','"+
				peopleObj.getLanguage()+"','"+peopleObj.getEmail()+"','"+peopleObj.getPrivilege();
        if(peopleObj instanceof Volunteer) {
        	Volunteer v = (Volunteer) peopleObj;
        	queryInsert = queryInsert.concat(", bartokens, available, paid");
        	queryValues = queryValues.concat("','"+v.getBartokens()+"','"+v.isAvailable()+"','"+v.isPaid());
        }
        else if(peopleObj instanceof Member) {
        	Member m = (Member) peopleObj;
        	queryInsert = queryInsert.concat(", signUpDate, roomReserved, periodReserved");
        	queryValues = queryValues.concat("','"+m.getSignUpDate()+"','"+m.getRoomReserved()+"','"+m.getPeriodReserved());
        }
        try {System.out.println(queryInsert.concat(")"+queryValues+"')"));
        	insertUpdateSQL(queryInsert.concat(")"+queryValues+"')"));
        }
        catch (Exception e) {
        	System.out.println("createPerson - Query exception: "+e);
		}
	}
	
	private void insertUpdateSQL(String query) throws Exception {
		int rc = -1;
		try {
        	Statement stmt = connection.createStatement();
        	stmt.setQueryTimeout(5);
        	rc = stmt.executeUpdate(query);
        	stmt.close();
        }
        catch(SQLException e) {
        	throw new Exception(""+e);
        }
	}
	
	private Volunteer creteExperienceSQL(Volunteer v) {
		try {
			Statement stmt = connection.createStatement();
		 	stmt.setQueryTimeout(5);
		 	ResultSet results = stmt.executeQuery("SELECT * FROM Experience WHERE email = '"+v.getEmail()+"'");
		 	while(results.next()) {
		 		v.addExperience(new Experience(results.getString("job"), Integer.parseInt(results.getString("shifts"))));
		 	}
	       	stmt.close();
		} catch (Exception e) {
			System.out.println("creteExperienceSQL - Query exception: "+e);
		}
		return v;
	}
	
	public void updatePeople(People oldObj, People newObj) {//System.out.println("");
		String queryUpdateSet = "UPDATE People SET ";
		String queryWhere = " WHERE email = '"+oldObj.getEmail()+"'";
		if(!oldObj.getEmail().equals(newObj.getEmail()))
        	queryUpdateSet = queryUpdateSet.concat("email = '"+newObj.getEmail()+"', ");
        if(!oldObj.getTelephoneNo().equals(newObj.getTelephoneNo()))
        	queryUpdateSet = queryUpdateSet.concat("telephoneNo = '"+newObj.getTelephoneNo()+"', ");
        if(!oldObj.getName().equals(newObj.getName()))
        	queryUpdateSet = queryUpdateSet.concat("name = '"+newObj.getName()+"', ");
        if(!oldObj.getSurname().equals(newObj.getSurname()))
        	queryUpdateSet = queryUpdateSet.concat("surname = '"+newObj.getSurname()+"', ");
        if(!oldObj.getLanguage().equals(newObj.getLanguage()))
        	queryUpdateSet = queryUpdateSet.concat("language = '"+newObj.getLanguage()+"', ");
        if(!oldObj.getPassword().equals(newObj.getPassword()))
        	queryUpdateSet = queryUpdateSet.concat("password = '"+newObj.getPassword()+"', ");
        if(oldObj.getPrivilege() != newObj.getPrivilege())
        	queryUpdateSet = queryUpdateSet.concat("administrator = '"+newObj.getPrivilege()+"', ");
        if(oldObj instanceof Volunteer && newObj instanceof Volunteer) {
        	Volunteer oldV = (Volunteer) oldObj;
        	Volunteer newV = (Volunteer) newObj;
        	if(oldV.getBartokens() != newV.getBartokens())
             	queryUpdateSet = queryUpdateSet.concat("bartokens = '"+newV.getBartokens()+"', ");
            if(oldV.isAvailable() != newV.isAvailable())
            	queryUpdateSet = queryUpdateSet.concat("available = '"+newV.isAvailable()+"', ");
            if(oldV.isPaid() != newV.isPaid())
            	queryUpdateSet = queryUpdateSet.concat("paid = '"+newV.isPaid()+"', ");
        }
        else if(oldObj instanceof Member && newObj instanceof Member) {
        	Member oldM = (Member) oldObj;
        	Member newM = (Member) newObj;
        	 if(!oldM.getSignUpDate().equals(newM.getSignUpDate()))
             	queryUpdateSet = queryUpdateSet.concat("signUpDate = '"+newM.getSignUpDate()+"', ");
             if(!oldM.getRoomReserved().equals(newM.getRoomReserved()))
             	queryUpdateSet = queryUpdateSet.concat("roomReserved = '"+newM.getRoomReserved()+"', ");
             if(!oldM.getPeriodReserved().equals(newM.getPeriodReserved()))
             	queryUpdateSet = queryUpdateSet.concat("periodReserved = '"+newM.getPeriodReserved()+"', ");
             if(queryUpdateSet.length() != 0) {
             	queryUpdateSet = "UPDATE Member SET "+queryUpdateSet.substring(0, queryUpdateSet.length()-2);
             	queryWhere = " WHERE email = '"+oldObj.getEmail()+"'";
             }
        }
        try {System.out.println("drukujquery2"+(queryUpdateSet.substring(0, queryUpdateSet.length()-2).concat(queryWhere)));
        	insertUpdateSQL((queryUpdateSet.substring(0, queryUpdateSet.length()-2).concat(queryWhere)));
        }
        catch(Exception e) {
        	System.out.println("updatePeople - Query exception: "+e);
        }
	}
	
	public void deletePerson(People p) {
		String queryUpdateSet = "UPDATE People SET ";
		String queryWhere = " WHERE email = '"+p.getEmail()+"'";
        if(p instanceof Volunteer) {
        	queryUpdateSet = queryUpdateSet.concat("bartokens = null, available = null, paid = null");
        }
        else if(p instanceof Member) {
        	queryUpdateSet = queryUpdateSet.concat("signUpDate = null, roomReserved = null, periodReserved = null");
        }
        else if(p instanceof Person) {
        	queryUpdateSet = "DELETE People";
        }
        try {System.out.println(queryUpdateSet.concat(queryWhere));
        	insertUpdateSQL(queryUpdateSet.concat(queryWhere));
        	if(!(p instanceof Person)) {
            	(new Thread(new DeleteTuple(p.getEmail()))).start();
            }
        }
        catch(Exception e) {
        	System.out.println("deletePerson - Query exception: "+e);
        }
	}
}