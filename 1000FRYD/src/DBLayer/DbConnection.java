package DBLayer;

import java.sql.*;

/**
 * @Author Kis Boisen Hansen
 * @Version 2006.10.02 - revised marts 2009 FEN
 * @version 2010.10.07 - new connection 
 * @version 2011.11.02 - new methods to handle transaction
 * This class is used to create the connection to the database
 * It is implemented as a singleton. The constructor is private to ensure that only
 * one object of the class is generated
 * Version for Sql Server 2014 the database i located on kraka.ucn.dk
 */

public class DbConnection
{
	//---------------------------------------------------------------------------
	private static final String  driver = "jdbc:sqlserver://kraka.ucn.dk:1433";
    private static final String  databaseName = ";databaseName=dmaj0914_2Sem_5";
    private static String  userName = ";user=dmaj0914_2Sem_5";
    private static String password = ";password=IsAllowed";
    //---------------------------------------------------------------------------
	private DatabaseMetaData metaData;
    private static Connection connection;
    private static DbConnection instance = null;

    // the constructor is private to ensure that only one object of this class is created
    private DbConnection()
    {
    	String url = driver + databaseName + userName + password;
        try
        {
        	//load of driver SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Load of class is ok");
        }
        catch(Exception e)
        {
            System.out.println("Can not find the driver");
            System.out.println(e.getMessage());
        }
        try
        {
            //connection to the database
            connection = DriverManager.getConnection(url);
            //set autocommit
            connection.setAutoCommit(true);
            metaData = connection.getMetaData(); //get meta data
            System.out.println("Connection to " + metaData.getURL());
            System.out.println("Driver " + metaData.getDriverName());
            System.out.println("Database product name " + metaData.getDatabaseProductName());
        }
        catch(Exception e)
        {
            System.out.println("Problems with the connection to the database");
            System.out.println(e.getMessage());
            System.out.println(url);
        }
    }//end  constructor
    
    public static void closeConnection() //closeDb: closes the connection to the database
    {
       	try
       	{
            connection.close();
            System.out.println("The connection is closed");
        }
         catch (Exception e)
       	{
            System.out.println("Error trying to close the database " +  e.getMessage());
        }
    }
    public Connection getDBcon()
    {
       return connection; //getDBcon: Get-method, returns the connection to the database
    }
    public static DbConnection getInstance()
    {
        if (instance == null)
        	instance = new DbConnection();
        return instance;
    }
    public static void startTransaction()
    {
    	try
    	{
    		connection.setAutoCommit(false);
    		System.out.println("start transaction ok");
    	}
    	catch(Exception e)
    	{
    		System.out.println("fail start transaction");
    		System.out.println(e.getMessage());
    	}
    }
    public static void commitTransaction()
    {
    	try
    	{
    		connection.setAutoCommit(true);
        }
    	catch(Exception e)
    	{
    		System.out.println("fail commit transaction");
    		System.out.println(e.getMessage());
    	}
    }
    public static void rollbackTransaction()
    {
    	try
    	{
    		connection.rollback();
    		connection.setAutoCommit(true);
        }
    	catch(Exception e)
    	{
    		System.out.println("fail rollback transaction");
    		System.out.println(e.getMessage());
    	}
    }
    public boolean statusConnection()
	{
		boolean state = false;
//		try {
//			connection.isValid(1000);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		try {
			Statement stmt = connection.createStatement();
			stmt.setQueryTimeout(3);
			stmt.executeQuery("select 1");//System.out.println(""+stmt.executeQuery("select 1"));
			stmt.close();
			state = true;
		}
		catch (Exception e) {
			System.out.println(""+e);
		}
		return state;
	}
}//end DbConnection