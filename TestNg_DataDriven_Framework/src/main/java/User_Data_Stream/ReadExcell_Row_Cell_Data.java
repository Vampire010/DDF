package User_Data_Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcell_Row_Cell_Data 
{
String path= "C:\\Users\\91973\\git\\DDF\\TestNg_DataDriven_Framework\\src\\main\\java\\Data_Source\\Read_Write.xlsx";
String sname ="user_cred";	
	public String getdata(int rno,int cno ) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook w = new XSSFWorkbook(fis);
	
		XSSFSheet s = w.getSheet(sname);
		
		String s1 = s.getRow(rno).getCell(cno).getStringCellValue();
		XSSFCell s2 = s.getRow(rno).createCell(cno);		
		return s1;		
	}
	
	public String Write_Data(int rno,int cno , String Status) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook w = new XSSFWorkbook(fis);
	
		XSSFSheet s = w.getSheet(sname);
		
		XSSFCell s2 = s.getRow(rno).createCell(cno);
		s2.setCellValue(Status);

		//To write into Excel File
		FileOutputStream outputStream = new FileOutputStream(path);
		w.write(outputStream);
		System.out.println("I have Written Test Results in Read_Write.xlsx ");
		
				return null;		
	}
	
}
