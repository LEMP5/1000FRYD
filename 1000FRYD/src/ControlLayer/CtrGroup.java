package ControlLayer;

import java.util.ArrayList;

import DBLayer.DbGroup;
import ModelLayer.Group;

public class CtrGroup {
	private static DbGroup dbGroup;
	
	public CtrGroup() {
		dbGroup = new DbGroup();
	}
	
	public ArrayList<Group> getAllGroups() {
		return dbGroup.getNamesGroups();
	}
	
	public Group getPeopleToGroup(Group g) {
		return dbGroup.getPeopleToGroup(g);
	}
	
	public ArrayList<String> getGroupsToPerson(String email) {
		return dbGroup.getGroupsToPerson(email);
	}
}
