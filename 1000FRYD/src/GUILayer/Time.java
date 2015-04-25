package GUILayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time
{
	
	public Time()
    {
        
    }
	
	public int getStartDay(int month, int year)
	{
		int day = 1;
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        if(d == 0)
        	return d+7;
        else
        	return d;
    }
	
	public int getDaysInMonth(int month, int year)
	{
		int[] daysInMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		boolean leapYear = false;
		if((year % 400 == 0)||((year % 4 == 0)&&(year % 100 != 0)))
            leapYear = true;
		if(leapYear == true && month == 2)
				return daysInMonth[month]+1;
		else
			return daysInMonth[month];
	}
    
    public int getActualDate(int part)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        String date = dateFormat.format(d);
        int dateOutput = 0;
        switch(part)
		{
			case 1:
				dateOutput = Integer.parseInt(date.substring(0,2));
			break;
			case 2:
				dateOutput = Integer.parseInt(date.substring(3,5));
			break;
			case 3:
				dateOutput = Integer.parseInt(date.substring(6,10));
			break;
		}
        return dateOutput;
    }

    public int numberOfWeek(int month, int year)
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(year, month-1, 1);
    	return calendar.get(Calendar.WEEK_OF_YEAR);
    }
    
    public String getActualTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
//    public String checkStringToInt(String data)
//    {
//        String dataa = data;
//        try
//        {int dataInt = Integer.parseInt(data.substring(0,data.length()));}
//        catch(Exception e)
//        {dataa = null;}
//        return dataa;
//    }
//    
//    public double checkStringToDouble(String data)
//    {
//        double dataInt = 0;
//        try
//        {dataInt = Double.parseDouble(data);}
//        catch(Exception e) {}
//        return dataInt;
//    }
}
