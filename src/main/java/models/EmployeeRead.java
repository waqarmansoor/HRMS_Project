package models;

import java.util.Date;

public class EmployeeRead {
	String name;
	String no;
	String time;
	String date;
	String status;
	
	
	public EmployeeRead() {
		
	}
	public EmployeeRead(String name, String no, String time,String date,String status) {
		super();
		this.name = name;
		this.no = no;
		this.date = date;
		this.time=time;
		this.status=status;
		this.date=date;
		
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public String getNo() {
		return no;
	}
	
	


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return this.no+" "+" "+this.date+" "+this.time+" "+" "+this.status;
	}
	
	
	
	
	
	

}
