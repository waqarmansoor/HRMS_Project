package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.EmployeeRead;
import models.EmployeeWrite;
import services.EmployeeAttendence;

public class ExcelSheetController {

	
	static Workbook workbook = null;
	static Sheet sheet=null;
	public static List<EmployeeRead> excelReader() {
		List<String> dataList=new ArrayList<>();
    	List<EmployeeRead> employeeList=new ArrayList<>();
    	String excelFilePath = "Res/Hr_V2.xlsx";
        FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
         
        
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                
                dataList.add(cell.getStringCellValue());

            }
            if(dataList.get(0).equals("Department")) 
            	dataList.clear();
            
            	
            if(!dataList.isEmpty())
            employeeList.add(new EmployeeRead(dataList.get(1),dataList.get(2),DateTime.getTime(dataList.get(3)),DateTime.getDate(dataList.get(3)),dataList.get(4)));
            
            dataList.clear();
        }
         
        try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        return employeeList;
	}
	
	
	
	public static void excelWriter() {
		    XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Sheet1");
	        XSSFCellStyle style = workbook.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.RED.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        List<String> employeeList=new ArrayList<>();
	        employeeList.add("No");
	        employeeList.add("Name");
	        employeeList.add("Date");
	        employeeList.add("Hours");
	        employeeList.add("Status");

	 
	        int rowCount = 0;
	        Row row;
	        Cell cell;
	        int columnCount=-1;
	        row=sheet.createRow(rowCount);
	        for(int i=0;i<5;i++) {
	        	cell=row.createCell(++columnCount);
	        	cell.setCellValue((String) employeeList.get(i) );
	        }
	         
	        for (EmployeeWrite employeeWrite : EmployeeAttendence.employeeWriteList) {
	            employeeList=employeeWrite.listConverter();
	        	 row = sheet.createRow(++rowCount);
	             
	             columnCount = -1;
	            
	            
	            for(int i=0;i<employeeList.size();i++) {
	            	cell = row.createCell(++columnCount);
	            	if(i==3 && employeeList.get(i)!=null&&Integer.parseInt(employeeList.get(i))<9) {
	            		cell.setCellStyle(style);
	            		
	            	}
	            	cell.setCellValue((String) employeeList.get(i));
	            }
	             
	            
	         
	         
	        try (FileOutputStream outputStream = new FileOutputStream("AttendenceSheet.xlsx")) {
	            workbook.write(outputStream);
	        } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	}
}
