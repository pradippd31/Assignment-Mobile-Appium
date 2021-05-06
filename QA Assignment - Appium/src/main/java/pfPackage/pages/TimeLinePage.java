//Page for TimeLine Page
package pfPackage.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pfPackage.base.BasePage;
import pfPackage.util.Constants;

public class TimeLinePage extends BasePage {
	
	
	//WebElement of the search box
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Search')]")	
	public AndroidElement SearchBox;
	
	//WebElement of Page menu
	@AndroidFindBy(id="com.kouzoh.mercari:id/MyPage")
	public AndroidElement MyPageMenu;
	
	//WebElement of Search button		
	@AndroidFindBy(className="android.widget.Button")
	public List<AndroidElement> SearchButton;
	
	//Constructor defined
	public TimeLinePage(AndroidDriver driver, ExtentTest eTest) {
		
		this.driver=driver;
		
		this.eTest=eTest;
	}
	
	//Reusable method for clicking PageMenu in timeline page
		public boolean pageMenu() {
		eTest.log(LogStatus.INFO, "Timeline Page is displayed");
		
		 MyPageMenu.click();
		 eTest.log(LogStatus.INFO, "User clicked on My Page Menu on timeline screen");
		 
		 MyPage myPage=new MyPage(driver,eTest);
		 
		 PageFactory.initElements(driver,myPage);
		 
		 boolean personalInfo= myPage.personalInfoPage();
		 
		 //clicking on My Page menu
		 MyPageMenu.click();
		 return personalInfo;
		 
		}
		
	//Reusable method for clicking Search box in timeline page
    	 public boolean timelineSearchBox() {
    		
	     //Clicking on Search Box
	     SearchBox.click();
	     eTest.log(LogStatus.INFO, "User clicked on searchbox in timeline screen");
	     
	     SearchBox.sendKeys("MacBook");    	    
	     eTest.log(LogStatus.INFO, "User entered MacBook in the search box");
	     
	     SearchButton.get(1).click();
	     eTest.log(LogStatus.INFO, "User clicked on search button");
	  
	     //Object for Search Items Page
	     SearchedItemsPage searchedItems=new SearchedItemsPage(driver,eTest);
	     
	     PageFactory.initElements(driver,searchedItems);
	     
	     boolean clickStatus=searchedItems.clickItem();
	     
	     return clickStatus;
	}	
}			
 	

	
		