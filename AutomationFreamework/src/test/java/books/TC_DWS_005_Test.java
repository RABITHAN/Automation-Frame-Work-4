package books;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.annotations.VisibleForTesting;

import Objectrepository.HomePage;
import dev.failsafe.internal.util.Assert;
import genericutility.BaseClass;

public class TC_DWS_005_Test extends BaseClass{
	
	

	public void clickOnBooks() {
		ExtentTest tset = extRepots.createTest("clickONBooks");
		hp = new HomePage(driver);
		hp.getBookLink().click();
		Assert.assertEquals(driver.getTitle(),("Demo web shop Books");
		
		test.log(Status.PASS,"Books page is displayed");
	}
	
	
}
