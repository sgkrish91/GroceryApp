package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
  @Test(enabled=false)
  public void f(Integer n, String s) {
  }

  @DataProvider(name="dataProvider")
  public Object[][] dpMethod() {
    return new Object[][] {{"hari","12345"}, {"Arun", "12345"}};
  }
}
