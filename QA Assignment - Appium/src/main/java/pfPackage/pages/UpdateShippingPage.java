//Page to update shipping address
package pfPackage.pages;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pfPackage.base.BasePage;

public class UpdateShippingPage extends BasePage {
	
	//WebElement of first name
	@AndroidFindBy(id="com.kouzoh.mercari:id/firstname")
	public AndroidElement first_name;
	
	//WebElement of last name	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Last name')]")
	public AndroidElement FamilyName;
	
	//WebElement of address line 01	
	@AndroidFindBy(id="com.kouzoh.mercari:id/AddressLine01")
	public AndroidElement AddressLine01;
	
	//WebElement of address line 02
	@AndroidFindBy(id="com.kouzoh.mercari:id/AddressLine02")
	public AndroidElement AddressLine02;
	
	//WebElement of ZIP Code
	@AndroidFindBy(id="com.kouzoh.mercari:id/ZIP")
	public AndroidElement Zip_code;
	
	//WebElement of city Code
	@AndroidFindBy(id="com.kouzoh.mercari:id/city")
	public AndroidElement city;
	
	//WebElement of Drop Down
	@AndroidFindBy(id="com.kouzoh.mercari:id/dropdown1")
	public AndroidElement StateDropDown;
	
	//WebElement of Update button
	@AndroidFindBy(xpath="//android.widget.TextView[@Text='Update']")
	public AndroidElement UpdateButton;
	
	//WebElement of success message
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Updated Successfully')]")
	public AndroidElement UpdateSuccessMessage;
	
	//Constructor code
	public UpdateShippingPage(AndroidDriver driver, ExtentTest eTest) {
		 this.driver=driver;
		 this.eTest=eTest;
	}

	//Reusable method for address update
	public boolean updateAddress() {
		
			//Entering 1st name by clearing the existing name
		    first_name.clear();
		    first_name.sendKeys("Pradip");
		
		    //Entering family name by clearing the existing name
		    FamilyName.clear();
		    FamilyName.sendKeys("Prasad");
		
		    //Entering address line #01 by clearing the existing address	
		    AddressLine01.clear();
		    AddressLine01.sendKeys("Plot B-123");
		
		    //Entering address line #02 by clearing the existing address	
		    AddressLine02.clear();
		    AddressLine02.sendKeys("Address 2");
		
		    //Entering ZIP Code by clearing the existing ZIP Code
		    Zip_code.clear();
		    Zip_code.sendKeys("12345");
		
		    //Entering city by clearing the existing city
		    city.clear();
		    city.sendKeys("Tokyo");
		
		    //Selecting state from drop down 
		    StateDropDown.click();
		    Select state=new Select(StateDropDown);
		    state.selectByVisibleText("New York");	
		    
		    //Clicking on the Update button
		    UpdateButton.click();
		    
		   //Verifying that new address is updated
	    	String AddressStatus=UpdateSuccessMessage.getText()	;
	    	
	    	boolean updateStatus;
	    	
		    if (updateStatus=AddressStatus.equals("Address is successfully updated"))
			  
		  {    
				return true;	
				
	      }else     {		
	    	  
				return false;	
				    }	
			
		   }
		
	}


