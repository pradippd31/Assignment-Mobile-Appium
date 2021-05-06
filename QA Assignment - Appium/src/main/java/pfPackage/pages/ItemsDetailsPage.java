//Page to verify displayed item name
package pfPackage.pages;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pfPackage.base.BasePage;

public class ItemsDetailsPage extends BasePage  {
		
    //WebElement of Item Details
	@AndroidFindBy(className="item-name")
	public AndroidElement ItemDetails;
	
	// Constructor code
	public ItemsDetailsPage(AndroidDriver driver, ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;
	}

	//Reusable method to verify that the item title is MacBook	  
	 public boolean verifyItemDetails() {
		boolean verifyStatus;
		ItemDetails.getText();
		eTest.log(LogStatus.INFO,"Item name fetched successfully" );
		
		String ItemTitle=ItemDetails.getText();
	 	// Splitting the title of Item
	 	    String SplitItemTitle[]=ItemTitle.split(" ");
	 	    
 	     //Verifying the name  of the items displayed uisng for loop
	 	    for (int i=0; i<SplitItemTitle.length; i++) {
	 	    
		        if(verifyStatus=SplitItemTitle[i].equals("p")) {
		        return true;
            }
	 	    }   return false; 
	}
}