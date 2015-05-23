package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class DbGroup {
	private Connection connection;
	
	public DbGroup() {
		connection = DbConnection.getInstance().getDBcon();
	}
	
	public ArrayList<Group> getNamesGroups() {
		ArrayList<Group> list = new ArrayList<Group>();
		try {
			Statement stmt = connection.createStatement();
		 	stmt.setQueryTimeout(5);
		 	ResultSet results = stmt.executeQuery("SELECT * FROM Groupp");
		 	while(results.next()) {
		 		list.add(new Group(results.getString("name")));
		 	}
	       	stmt.close();
		} catch (Exception e) {
			System.out.println("getNamesGroups - Query exception: "+e);
		}
		return list;
	}
	
	public Group getPeopleToGroup(Group g) {
		DbPeople dbP = new DbPeople();
		ArrayList<People> list = new ArrayList<People>();
		try {
			Statement stmt = connection.createStatement();
		 	stmt.setQueryTimeout(5);
		 	ResultSet results = stmt.executeQuery("SELECT * FROM Slot WHERE groupName = '"+g.getName()+"'");
		 	while(results.next()) {
		 		list.add(dbP.resultsSQLPeople(results.getString("email")));
		 	}
		 	g.setPeopleList(list);
	       	stmt.close();
		} catch (Exception e) {
			System.out.println("getPeopleToGroup - Query exception: "+e);
		}
		return g;
	}
	
	public ArrayList<String> getGroupsToPerson(String email) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			Statement stmt = connection.createStatement();
		 	stmt.setQueryTimeout(5);
		 	ResultSet results = stmt.executeQuery("SELECT * FROM Slot WHERE email = '"+email+"'");
		 	while(results.next()) {
		 		list.add(results.getString("groupName"));
		 	}
	       	stmt.close();
		} catch (Exception e) {
			System.out.println("getPeopleToGroup - Query exception: "+e);
		}
		return list;
	}
}
