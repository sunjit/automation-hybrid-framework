package executionEngine;

import org.testng.annotations.Test;

import Config.Constants;
import utility.ExcelUtils;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	public static ChromeDriver IeDriver;
  @Test
  public void test() throws Exception {
	  
	  Execute_test_cases test1 = new Execute_test_cases();
	  test1.execute_TestCase();
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  
		ExcelUtils.setExcelFile(Constants.Path_TestData);
  }

  @AfterTest
  public void afterTest() {
  }

}
