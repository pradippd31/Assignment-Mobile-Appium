package pfPack.tests.base;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pfPackage.util.Constants;
import pfPackage.util.ExtentManager;

public class BaseTest {
		
	public ExtentReports eReport = ExtentManager.getInstance();
	public ExtentTest eTest = null;
	public AndroidDriver<AndroidElement>driver=null;
	
	//Setting up Capabilities
	public void capabilities(String deviceType)throws MalformedURLException {
		File app=new File("Mercari.apk");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		//Verifying device type
		if (deviceType.equalsIgnoreCase("emulator")) {		
 		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PradipEmulator");
	    }
		
		else if (deviceType.equalsIgnoreCase("real")) {		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");		
	    }
 	     	
 		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
 		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

 		eTest.log(LogStatus.INFO,"Successfully Launched the Device "+deviceType);
 		
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		
	}
  
	public void reportPass(String message) {
		
		eTest.log(LogStatus.PASS,message);
	}
	
	public void reportFail(String message) {
		
		eTest.log(LogStatus.FAIL,message);
		
		//Taking screenshot when the scenario is failed
		takeScreenshot();
		
		//Using TestNG asserting fail
		Assert.fail(message);
	}
	
	public void takeScreenshot(){
		// fileName of the screenshot
		Date date=new Date();
		String screenshotFile=date.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//put screenshot file into the reports
		eTest.log(LogStatus.INFO,"Screenshot-> "+ eTest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
	}

}
