package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	
	public static Properties prop;
	
	public static void testBasic() throws IOException {
		prop=new Properties();		
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");	
		prop.load(ip);	
	}
	
	ExcelRead er=new ExcelRead();

	@DataProvider(name = "dataProvider")
	public Object[][] dpMethod() throws IOException {
		testBasic();
		return new Object[][] { { er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 1, 0), er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 1, 1)}, { er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 2, 0), er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 2, 1) } };
	}

}
