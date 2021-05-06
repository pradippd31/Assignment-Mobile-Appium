package pfPack.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.tests.base.BaseTest;
import pfPackage.pages.TimeLinePage;
import pfPackage.util.Constants;
import pfPackage.util.ExtentManager;

public class MercariScenario02 extends BaseTest{
	
	@Test
	public void scenarioTwo() throws MalformedURLException {
		
        eTest=eReport.startTest("Scenario 2");
		
		eTest.log(LogStatus.INFO, "App is being launched");
		
		capabilities(Constants.Device_Type);
		TimeLinePage timeLinePage=new TimeLinePage(driver,eTest);
		
		PageFactory.initElements(driver,timeLinePage );
		
		boolean searchStatus=timeLinePage.timelineSearchBox();
		
		if (searchStatus) {
			//Calling reportPass method in baseTest
			reportPass("Scenario 02 - MacBook is searched as Product");
			
		}else {
			//Calling reportFail method in baseTest
			reportFail("Scenario 02 - MacBook is not searched as Product");
			
		}
	}
	//Method to report pass or fail
	@AfterMethod
	public void testClosure() {
		
		if(eReport!=null) {
			
			eReport.endTest(eTest);
			//Storing logs in the report
			eReport.flush();
			}
		if (driver!=null) {
			driver.close();
		}
		}
}
