package Config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import executionEngine.DriverScript;
//import utility.Log;
import utility.ExcelUtils;
import Config.Constants;
 
@SuppressWarnings("unused")
public class ActionKeywords {
 
		public static ChromeDriver IeDriver;		
		public static int sObjRefRowID;
		public static String sObjectID;
        
		
		
	public static void openBrowser(String object, String data){	
		//Log.info("Opening Browser");
		try {
			
			System.setProperty("webdriver.chrome.driver", "//paste the location of webdriver//");
			IeDriver = new ChromeDriver();
			IeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			IeDriver.get(Constants.URL);
			//Log.info("Chrome browser started");
			System.out.println(IeDriver);
			
		}catch (Exception e){
			
			System.out.println(" error message" + e.getMessage());
			//Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	
	/*public static void openURL(String object, String data){
		try{
			//Log.info("Navigating to URL");
			IeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			IeDriver.get(Constants.URL);
		}catch(Exception e){
			//Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}*/
	
	public static void clearText(String object, String data){
		try{
			//Log.info("Clearing the text in " + object);
			
					
			if (!object.isEmpty()){
	  		      sObjRefRowID = ExcelUtils.getRowContains(object, Constants.Col_ObjectReference, Constants.Sheet_ObjectRepository);
	  		      sObjectID = ExcelUtils.getCellData(sObjRefRowID, Constants.Col_ObjectID, Constants.Sheet_ObjectRepository);
	  		}
			//System.out.println(IeDriver);
			IeDriver.findElementByXPath(sObjectID).clear();
		 }catch(Exception e){
			  //Log.error("Not able to Clear Field --- " + e.getMessage());
			 System.out.println(" error message" + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		
	}
	public static void enterText(String object, String data){
		try{
			//Log.info("Entering the text in " + object);
			if (!object.isEmpty()){
  		      sObjRefRowID = ExcelUtils.getRowContains(object, Constants.Col_ObjectReference, Constants.Sheet_ObjectRepository);
  		      sObjectID = ExcelUtils.getCellData(sObjRefRowID, Constants.Col_ObjectID, Constants.Sheet_ObjectRepository);
  		}
			System.out.println(IeDriver);
			IeDriver.findElementByXPath(sObjectID).sendKeys(data);
		 }catch(Exception e){
			// Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
	}
	
	public static void submit(String object, String data){
		try{
			//Log.info("Submitting the form button " + object);
			if (!object.isEmpty()){
	  		      sObjRefRowID = ExcelUtils.getRowContains(object, Constants.Col_ObjectReference, Constants.Sheet_ObjectRepository);
	  		      sObjectID = ExcelUtils.getCellData(sObjRefRowID, Constants.Col_ObjectID, Constants.Sheet_ObjectRepository);
			}
	  		      IeDriver.findElementByXPath(sObjectID).click();
	  		      
			
		 }catch(Exception e){
			 //Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		
	}
	
	public static void waitForPageLoad(String object, String data) throws Exception{
		try{
			//Log.info("Wait for 10 seconds");
			Thread.sleep(10000);
		 }catch(Exception e){
			 //Log.error("Not able to Wait --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
	}
	
	public static void closeBrowser(String object, String data){
		
		try{
			//Log.info("Closing the browser");
			IeDriver.quit();
		 }catch(Exception e){
			 //Log.error("Not able to Close the Browser --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		
	}
	
	public static void selectRadioBttn(String object, String data){
		
		try{
			//Log.info("Select The RadioButton " + object);
			if (!object.isEmpty()){
	  		      sObjRefRowID = ExcelUtils.getRowContains(object, Constants.Col_ObjectReference, Constants.Sheet_ObjectRepository);
	  		      sObjectID = ExcelUtils.getCellData(sObjRefRowID, Constants.Col_ObjectID, Constants.Sheet_ObjectRepository);
	  		}
			
			IeDriver.findElementByXPath(sObjectID).click();
		 }catch(Exception e){
			 //Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		
	}
	
	public static void checkCheckBox(String object, String data){
		
		try{
			//Log.info("Select The Checkbox " + object);
			if (!object.isEmpty()){
	  		      sObjRefRowID = ExcelUtils.getRowContains(object, Constants.Col_ObjectReference, Constants.Sheet_ObjectRepository);
	  		      sObjectID = ExcelUtils.getCellData(sObjRefRowID, Constants.Col_ObjectID, Constants.Sheet_ObjectRepository);
	  		}
			
			IeDriver.findElementByXPath(sObjectID).click();
		 }catch(Exception e){
			// Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
	}
	
	}

