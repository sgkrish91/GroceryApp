package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	
	public static Properties prop;
	ExcelRead er=new ExcelRead();
	
	public static void testBasic() throws IOException {
		ExcelRead er=new ExcelRead();
		prop=new Properties();		
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 36, 1));	
		prop.load(ip);	
	}
	
	

	@DataProvider(name = "dataProvider")
	public Object[][] dpMethod() throws IOException {
		testBasic();
		return new Object[][] { { er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 1, 0), er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 1, 1)}, { er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 2, 0), er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 2, 1) } };
	}

}
