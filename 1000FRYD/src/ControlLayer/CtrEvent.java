package ControlLayer;

import DBLayer.DbConnection;
import DBLayer.DbEvent;
import ModelLayer.Event;

public class CtrEvent {
	private DbEvent dbEvent;
	
	
	public CtrEvent() {
		this.dbEvent = new DbEvent();
	}

	public void createEvent(String n, String d, int sH, int eH) throws Exception {
		Event ev = new Event(0, n,  d, sH, eH);
		try {
			DbConnection.startTransaction();
            dbEvent.insertEvent(ev);
            DbConnection.commitTransaction();
		} catch (Exception ex) {
			DbConnection.rollbackTransaction();
            throw new Exception("Not inserted");
		}
	}
	
	public void updateEvent(Event ev) throws Exception {
		try {
			DbConnection.startTransaction();
            dbEvent.updateEvent(ev);
            DbConnection.commitTransaction();
		} catch (Exception e) {
			DbConnection.rollbackTransaction();
            throw new Exception("Not updated");
		}
	}
	
	public void deleteEvent(Event ev) throws Exception {
		try {
			DbConnection.startTransaction();
            dbEvent.delete(ev);
            DbConnection.commitTransaction();
		} catch (Exception e) {
			DbConnection.rollbackTransaction();
            throw new Exception("Not updated");
		}
	}
}
