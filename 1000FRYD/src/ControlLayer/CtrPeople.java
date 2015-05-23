package ControlLayer;

import DBLayer.DbConnection;
import DBLayer.DbPeople;
import ModelLayer.*;

public class CtrPeople {
	private static DbPeople dbPeople;
	
	public CtrPeople() {
		dbPeople = new DbPeople();
	}
	
	public People[] getPerson(String email) {
		return dbPeople.getPerson(email);
	}
	
	public void createVolunteer(String telephoneNo, String name, String surname,
			String language, String password, boolean privilege, String email,
			int bartokens, boolean available, boolean paid) throws Exception {
		Volunteer v = new Volunteer(telephoneNo, name, surname, language, password,
									privilege, email, bartokens, available, paid);
		try {
			DbConnection.startTransaction();
            dbPeople.createPerson(v);
            DbConnection.commitTransaction();
		} catch (Exception e) {
			DbConnection.rollbackTransaction();
            throw new Exception("Not inserted");
		}
	}
	
	public void createMember(String telephoneNo, String name, String surname,
			String language, String password, boolean privilege, String email,
			String signUpDate, String roomReserved, String periodReserved) throws Exception {
		Member m = new Member(telephoneNo, name, surname, language, password, privilege,
								email, signUpDate, roomReserved, periodReserved);
		try {
			DbConnection.startTransaction();
            dbPeople.createPerson(m);
            DbConnection.commitTransaction();
		} catch (Exception e) {
			DbConnection.rollbackTransaction();
            throw new Exception("Not inserted");
		}
	}
	
	public void createPerson(String telephoneNo, String name, String surname,
			String language, String password, boolean privilege, String email) throws Exception {
		Person p = new Person(telephoneNo, name, surname, language, password, privilege, email);
		try {
			DbConnection.startTransaction();
            dbPeople.createPerson(p);
            DbConnection.commitTransaction();
		} catch (Exception e) {
			DbConnection.rollbackTransaction();
            throw new Exception("Not inserted");
		}
	}
	
	public void updatePerson(People oldObj, People newObj) throws Exception {
		try {
			DbConnection.startTransaction();
            dbPeople.updatePeople(oldObj, newObj);
            DbConnection.commitTransaction();
		} catch (Exception e) {
			DbConnection.rollbackTransaction();
            throw new Exception("Not updated");
		}
	}
	
	public void deletePerson(People p) throws Exception {
		try {
			DbConnection.startTransaction();
            dbPeople.deletePerson(p);
            DbConnection.commitTransaction();
		} catch (Exception e) {
			DbConnection.rollbackTransaction();
            throw new Exception("Not updated");
		}
	}
}
