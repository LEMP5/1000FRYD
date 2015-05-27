package ControlLayer;

import java.util.ArrayList;
import java.util.Calendar;

import ModelLayer.Day;
import DBLayer.DbDay;

public class CtrDay {
	private static DbDay dbDay;
	private String[] daysOfWeek;

	public CtrDay() {
		super();
		dbDay = new DbDay();
		daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	}
	
	public ArrayList<Day> getWeek(int weeksAhead){
		ArrayList<Day> week= new ArrayList<Day>();;
		Calendar calendar = Calendar.getInstance();
        int t = calendar.get(Calendar.DAY_OF_WEEK)-1;
        calendar.add(Calendar.DAY_OF_MONTH, -(t) + 7 * (weeksAhead));
        Day dayObj;
        for(int i = 0; i <7; i++){
        	String date = "" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        	dayObj = new Day(date, daysOfWeek[i]);
        	week.add(dayObj);
        	dbDay.getDay(date, daysOfWeek[i]);
        	calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return week;
	}
}
