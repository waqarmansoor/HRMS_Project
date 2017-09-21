package services;

import java.util.ArrayList;
import java.util.List;

import models.EmployeeRead;
import models.EmployeeWrite;
import util.DateTime;

public class EmployeeAttendence {
	
	/**
	 * employeelist on the basis of id
	 */
	static List<EmployeeRead> empList=new ArrayList<>();
	/**
	 * employeelist on the basis of date of particular id
	 */
	static List<EmployeeRead> empListByDate=new ArrayList<>();
	
	/**
	 * final generated employee list
	 */
	public static List<EmployeeWrite> employeeWriteList=new ArrayList<>();
	
	/**
	 * This method extract list on the basis of id
	 * and delegates it command to date Parser
	 * @param empReadList
	 */
	
	public static void listParser(List<EmployeeRead> empReadList) {
		for (int i=0;i<empReadList.size();i++) {
			
			if(empList.size()==0) {	
				empList.add(empReadList.get(i));
				
			}else if(empList.get(0).getNo().equals(empReadList.get(i).getNo())){
				empList.add(empReadList.get(i));
			}else {
				dateParser();
				empList.clear();
				i--;
			}
			
		}
	}
	
	/**
	 * 
	 * This methods extracts list on the basis of date
	 * and delegates its command to object Generator
	 */

	private static void dateParser() {
		
		for(int i=0;i<empList.size();i++) {
			
			if(empListByDate.size()==0) {
				empListByDate.add(empList.get(i));
			}else if(empListByDate.get(0).getDate().equals(empList.get(i).getDate())) {
				empListByDate.add(empList.get(i));
			}else {	
				objectGenerator();
				empListByDate.clear();
				i--;
				
			}
		}	
	}
	
	
	/**
	 * This method generates object of EmployeeWrite
	 * it uses two methods getCheckIn() and getCheckOut() 
	 */

	private static void objectGenerator() {
		String hours = null;
		String status = null;	
		EmployeeRead employeeRead;
		employeeRead=empListByDate.get(0);
		if(getCheckIn()!=-1) {
			if(getCheckOut()!=-1) {	
				hours=DateTime.getHours(empListByDate.get(getCheckIn()).getTime(), empListByDate.get(getCheckOut()).getTime());
				status=(Integer.parseInt(hours)<9)? "Less Hours":" Normal Hours";
			}else {
				status="No Check Out";
			}
			
		}else {
			status="No Check In";
		}
		
		employeeWriteList.add(new EmployeeWrite(employeeRead.getName(),employeeRead.getNo(),hours,status,employeeRead.getDate()));
		
		
	}
	
	/**
	 * 
	 * 
	 * @return id of first check in
	 */
	
	private static int getCheckIn() {
		for(int i=0;i<empListByDate.size();i++) {
			if(empListByDate.get(i).getStatus().equals("C/In"))
				return i;
		}
		return -1;
	}
	
	/**
	 * 
	 * 
	 * @return id of last checkout
	 */
	private static int getCheckOut() {
		for(int i=empListByDate.size()-1 ;i>0;i--) {
			if(empListByDate.get(i).getStatus().equals("C/Out"))
				return i;
		}
		return -1;
	}
	
	
	
	

}
