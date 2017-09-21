package com.waqar.hr;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.EmployeeRead;
import models.EmployeeWrite;
import services.EmployeeAttendence;
import util.DateTime;
import util.ExcelSheetController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	List<EmployeeRead> employeeList=ExcelSheetController.excelReader();
    	        
        //System.out.println(employeeList);
        
        EmployeeAttendence.listParser(employeeList);
        for(EmployeeWrite empwrite:EmployeeAttendence.employeeWriteList) {
        	  System.out.println(empwrite);
        }
      
        ExcelSheetController.excelWriter();
        
        
        
    }
}
