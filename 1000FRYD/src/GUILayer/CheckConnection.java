package GUILayer;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DBLayer.DbConnection;

public class CheckConnection extends Thread{
	private CalendarMenu shared;
	private DbConnection connection;
	private static int time = 20000;
	
    public CheckConnection(CalendarMenu shared)
    {
    	super("Connection");
        this.shared = shared;
        connection = DbConnection.getInstance();
    }

    public void run()
    {
    	int i = 0;
        while(true)
        {
        	boolean status = false;
//            if(i%2 == 0)
//            	shared.checkConnection(Color.GREEN);
//            else
//            	shared.checkConnection(Color.RED);
        	//System.out.println("aaa");
        	
        	try{status = connection.statusConnection();}
        	catch (Exception e){}
        	
            if(status)
            	shared.checkConnection(Color.GREEN);
            else
            	shared.checkConnection(Color.RED);
            try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}
