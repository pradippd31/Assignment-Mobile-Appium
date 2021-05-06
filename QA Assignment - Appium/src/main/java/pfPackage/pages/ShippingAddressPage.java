//Page for tapping on shipping address link
package pfPackage.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pfPackage.base.BasePage;

public class ShippingAddressPage extends BasePage {
		
	//WebElement of Shipping Address
		
	@AndroidFindBy(uiAutomator="text(\"View Profile\")")
	public AndroidElement ShippingAddress;
	
	//Constructor code
	public ShippingAddressPage(AndroidDriver driver, ExtentTest eTest) {
	 this.driver=driver;
	 this.eTest=eTest;
	}

		//Reusable method for shipping address
		   public boolean shippingAddressMenu() {
			ShippingAddress.click();
			eTest.log(LogStatus.INFO,"User clicked on the Shipping address link");
			
			UpdateShippingPage searchedItems=new UpdateShippingPage(driver,eTest);
			
		    boolean updateAddress=searchedItems.updateAddress();
			return updateAddress;
			
		}
	

}



