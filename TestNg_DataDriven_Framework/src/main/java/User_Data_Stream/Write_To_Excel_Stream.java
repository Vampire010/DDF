package User_Data_Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_To_Excel_Stream 
{

	public void Write_Me(String UserName , String Passsword , String Result ) throws EncryptedDocumentException, IOException
	{
		InputStream inp = new FileInputStream("C:\\Users\\91973\\eclipse-workspace\\TestNg_DataDriven_Framework\\src\\main\\java\\Data_Source\\Login_Test_Result.xlsx");
		Workbook wb = WorkbookFactory.create(inp);

		Sheet sh =  wb.getSheet("validation_Test");
  
		int num = sh.getLastRowNum();
	    Row row = sh.createRow(++num);
	    
	    
        // This data needs to be written (Object[])
        Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
        
        data.put(1, new Object[]{ "USERNAME", "PASSWORD"});
        
	        data.put(2, new Object[]{UserName, Passsword ,Result });
        
		
        // Iterate over data and write to sheet
        Set<Integer> keyset = data.keySet();
        int rownum = 1;
        for (Integer key : keyset)
        {
           
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                // this line creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String)obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
      
        try 
        {
            // this Writes the workbook gfgcontribute
        	FileOutputStream fileOut = new FileOutputStream("C:\\Users\\91973\\eclipse-workspace\\TestNg_DataDriven_Framework\\src\\main\\java\\Data_Source\\Login_Test_Result.xlsx");
            wb.write(fileOut);
            fileOut.close();
            System.out.println("Login_Test_Result.xlsx written successfully on disk.");
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}

}
