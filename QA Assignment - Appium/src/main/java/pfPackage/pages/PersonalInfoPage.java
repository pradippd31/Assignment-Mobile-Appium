//Page to tap on Personal Profile link
package pfPackage.pages;

import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pfPackage.base.BasePage;

public class PersonalInfoPage extends BasePage {
	//WebElement of View Profile	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'View profile')]")
	public AndroidElement PersonalInfo;
	
	// Constructor code
	public PersonalInfoPage(AndroidDriver driver, ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;
	}

		//Reusable method for clicking on Personal Profile
		public boolean personalProfilePage() {
			PersonalInfo.click();
			eTest.log(LogStatus.INFO,"User clicked on the Personal Profile ");
			
			ShippingAddressPage shippingAddress=new ShippingAddressPage(driver,eTest);
			PageFactory.initElements(driver,shippingAddress);
			
			boolean verifyPersonalProfile=shippingAddress.shippingAddressMenu();
			return verifyPersonalProfile;
		}

}
