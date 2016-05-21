package executionEngine;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;

import Config.ActionKeywords;
import Config.Constants;
import utility.ExcelUtils;

public class Execute_test_cases {
	
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	public static Method method[];

	public static int iTestStep;
	public static int iTestStepstart;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;
	public static String sData;
	public static int sObjRefRowID;
	public static String sObjectID;
	public static boolean bResult;
	//public static ChromeDriver IeDriver;
	
	public Execute_test_cases() throws NoSuchMethodException, SecurityException{
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
		System.out.println("number of methods in actionword" +method.length);
		
		/*for (int i=0;i<method.length;i++)
		{
			System.out.println(method[i]);
		}
		*/
		
	}
	
	
	public void execute_TestCase() throws Exception {
	 	
	   	int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
		for(int iTestcase=1;iTestcase<iTotalTestCases;iTestcase++){
			bResult = true;
			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestScriptID, Constants.Sheet_TestCases); 
			sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
			if (sRunMode.equals("Yes")){
				//Log.startTestCase(sTestCaseID);
				iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestScriptName, Constants.Sheet_TestScripts);
				iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestScripts, sTestCaseID, iTestStep);
				bResult=true;
				for (iTestStepstart = iTestStep;iTestStepstart<iTestLastStep;iTestStepstart++){
		    		sActionKeyword = ExcelUtils.getCellData(iTestStepstart, Constants.Col_ActionKeyword,Constants.Sheet_TestScripts);
		    		sPageObject = ExcelUtils.getCellData(iTestStepstart, Constants.Col_PageObject, Constants.Sheet_TestScripts);
		    		sData = ExcelUtils.getCellData(iTestStepstart, Constants.Col_DataSet, Constants.Sheet_TestScripts);
		    		
		    		execute_Actions();
					if(bResult==false){
						ExcelUtils.setCellData(Constants.KEYWORD_FAIL,iTestcase,Constants.Col_TestScriptResult, Constants.Sheet_TestCases);
						//Log.endTestCase(sTestCaseID);
						break;
						}						
					}
				if(bResult==true){
				ExcelUtils.setCellData(Constants.KEYWORD_PASS,iTestcase,Constants.Col_TestScriptResult, Constants.Sheet_TestCases);
				//Log.endTestCase(sTestCaseID);	
					}					
				}
			}
		}	

 public static void execute_Actions() throws Exception {
	 
 	for(int i=0;i<method.length;i++){

 		System.out.println(sActionKeyword);
		if(method[i].getName().equals(sActionKeyword)){
			method[i].invoke(actionKeywords,sPageObject, sData);
			if(bResult==true){
				ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStepstart, Constants.Col_TestStepResult, Constants.Sheet_TestScripts);
				break;
			}else{
				ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStepstart, Constants.Col_TestStepResult, Constants.Sheet_TestScripts);
				ActionKeywords.closeBrowser("","");
				break;
				}
			}
		}
 }


}
