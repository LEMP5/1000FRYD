package GUILayer;

import ModelLayer.*;

public class CopyPerson {
	
	public CopyPerson() {
		
	}

	public People getCopy(People p) {
		People pNew = null;
		if(p instanceof Volunteer) {
			Volunteer v = (Volunteer) p;
			pNew = new Volunteer(v.getTelephoneNo(), v.getName(), v.getSurname(),
					v.getLanguage(), v.getPassword(), v.getPrivilege(), v.getEmail(),
					v.getBartokens(), v.isAvailable(), v.isPaid());
			((Volunteer) pNew).setExperienceList(((Volunteer) p).getExperienceList());
		}
		else if(p instanceof Member) {
			Member m = (Member) p;
			pNew = new Member(m.getTelephoneNo(), m.getName(), m.getSurname(),
					m.getLanguage(), m.getPassword(), m.getPrivilege(), m.getEmail(),
					m.getSignUpDate(), m.getRoomReserved(), m.getPeriodReserved());
		}
		else if(p instanceof Person) {
			Person v = (Person) p;
			pNew = new Person(v.getTelephoneNo(), v.getName(), v.getSurname(),
					v.getLanguage(), v.getPassword(), v.getPrivilege(), v.getEmail());
		}
		return pNew;
	}
}