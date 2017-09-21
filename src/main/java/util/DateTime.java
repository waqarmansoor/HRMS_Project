package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
	
	static SimpleDateFormat inputFormat=new SimpleDateFormat("M/dd/yyyy hh:mm:ss aa");
	static SimpleDateFormat dateFormat=new SimpleDateFormat("M/dd/yyyy");
	static SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
	static SimpleDateFormat timeFormat2=new SimpleDateFormat("HH");
	static Calendar calendar=Calendar.getInstance();
	static Date outputDate;
	
	public static String getDate(String inputDate){
		try {
			outputDate=inputFormat.parse(inputDate);
		} catch (ParseException e) {
			System.out.println("DataParser Method in DateTime.class throwing Exception\n"+e);
		}
		return dateFormat.format(outputDate);
	}
	
   public static String getTime(String inputDate) {
	   try {
			outputDate=inputFormat.parse(inputDate);
		} catch (ParseException e) {
			System.out.println("DataParser Method in DateTime.class throwing Exception\n"+e);
		}
		return timeFormat.format(outputDate);
   }
   
   public static String getHours(String startTime,String endTime) {
	   int hours;
	   int minutes;
	   
   try {
	   hours=timeFormat.parse(endTime).getHours()-timeFormat.parse(startTime).getHours();
	   minutes=timeFormat.parse(endTime).getMinutes()-timeFormat.parse(startTime).getMinutes();
	   if((minutes)<1) {
		   hours -=1;
		   return String.valueOf(hours);
	   }else {
		   return String.valueOf(hours);
	   }
	      
	} catch (ParseException e) {
		e.printStackTrace();
	}
	   
	   return null;
   }
	
	
	

}
