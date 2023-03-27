package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	
    public static Properties prop;
	
	public static void testBasic() throws IOException {
		prop=new Properties();		
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");	
		prop.load(ip);	
	}
	
	public static String readStringData(String excel, String sheet, int i, int j) throws IOException
	{
		testBasic();
		f=new FileInputStream(System.getProperty("user.dir")+ excel);		//Fetching the file from the specified path
		w=new XSSFWorkbook(f);		//Fetching the workbook from the file
		s=w.getSheet(sheet);		//Fetching the sheet named Sheet1 from the workbook
		Row r=s.getRow(i);		//Method to get the row
		Cell c=r.getCell(j);	//Method to get the column
		return c.getStringCellValue();		//Method to fetch the String value from the column
		
	}
	
	public static String readIntegerData(String excel, String sheet, int i, int j) throws IOException
	{
		f=new FileInputStream(System.getProperty("user.dir")+ excel);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		Row r=s.getRow(i);
		Cell c=r.getCell(j);
		int a=(int) c.getNumericCellValue();		//To get the numeric value from the column
		return String.valueOf(a);		//We are converting the integer value to string format to return to the main method
	}

}
