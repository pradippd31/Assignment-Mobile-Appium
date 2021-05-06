//Page to tap on third item after search
package pfPackage.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class SearchedItemsPage extends BasePage {
	
	//WebElement of Third Item
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'MacBook')]")
	public List<AndroidElement> ThirdItem;
	
    //Constructor code	
	public SearchedItemsPage(AndroidDriver driver, ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;
	}
        //Reusable method for clicking third item
		public boolean clickItem() {
		
			ThirdItem.get(3).click();
            eTest.log(LogStatus.INFO,"User clicked on the third item");
			
			ItemsDetailsPage itemsDetails=new ItemsDetailsPage(driver,eTest);
			PageFactory.initElements(driver,itemsDetails);
			
			boolean verifyProductName=itemsDetails.verifyItemDetails();
			
			return verifyProductName;
		}	
 	

}
