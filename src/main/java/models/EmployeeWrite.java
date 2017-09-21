package models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeWrite {
	
	String name;
	String no;
	String hours ;
	String status;
	String date;
	
	List<String> empList=new ArrayList<String>();
	
	
	
	public EmployeeWrite(String name, String no, String hours, String status, String date) {
		super();
		this.name = name;
		this.no = no;
		this.hours = hours;
		this.status = status;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return this.name+" "+this.no+" "+this.date+" "+this.hours+" "+this.status;
	}
	
	public  List<String> listConverter(){
		empList.add(this.no);
		empList.add(this.name);
		empList.add(this.date);
		empList.add(this.hours);
		empList.add(this.status);	
		return empList;	
	}
}
