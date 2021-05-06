//Page to tap on My Page menu
package pfPackage.pages;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pfPackage.base.BasePage;
public class MyPage extends BasePage {
	
		
	//WebElement of Personal Information
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Personal Information')]")
	public AndroidElement PersonalInfo;
		
		//Constructor code
		public MyPage(AndroidDriver driver, ExtentTest eTest) {
			this.driver=driver;
			this.eTest=eTest;
		
		}
		//Reusable method for clicking on Personal Profile
		public boolean personalInfoPage() {
		//Clicking on My Page menu
			PersonalInfo.click();
			eTest.log(LogStatus.INFO,"User clicked on the Personal Info link");
					
			PersonalInfoPage  personalInfo=new PersonalInfoPage(driver,eTest);	
			PageFactory.initElements(driver,personalInfo);
			
			boolean verifyPersonalProfile=personalInfo.personalProfilePage();
			
			return	verifyPersonalProfile;
					
				}

}





