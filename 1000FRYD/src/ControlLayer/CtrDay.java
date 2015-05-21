package ControlLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import ModelLayer.Day;

public class CtrDay {
	private ArrayList<Day> week;
	private String[] daysOfWeek;
	private Day today;

	public CtrDay() {
		super();
		week = new ArrayList<Day>();
		daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	}
	
	public void createDay(int weeksAhead){
		Calendar calendar = Calendar.getInstance();
        int t = calendar.get(Calendar.DAY_OF_WEEK)-1;
        calendar.add(Calendar.DAY_OF_MONTH, -(t) + 7 * (weeksAhead));
        for(int i = 0; i <7; i++){
        	String date = "" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        	new Day(date, daysOfWeek[i]);
        	calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
	}

	private int getDayOfTheWeek(){
        Calendar calendar = Calendar.getInstance();
        int t = calendar.get(Calendar.DAY_OF_WEEK);
        if(t==1)
        return 7;
        else
        return calendar.get(Calendar.DAY_OF_WEEK)-1;
    }
	
	private int getFirstDayOfWeek(){
		Calendar calendar = Calendar.getInstance();
        int t = calendar.get(Calendar.DAY_OF_WEEK);
		return t;
	}
}
