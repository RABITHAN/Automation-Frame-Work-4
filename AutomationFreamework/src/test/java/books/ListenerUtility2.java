package books;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;

public class ListenerUtility2  extends BaseClass implements ITestListener{
	
	@Override
	
	 public void onTestFailure(ITestResult result) {
		String MethodName = result.getName();//to capture method name
		test.log(Status.FAIL, MethodName+"is failed");
		
		TakesScreenshot  ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+MethodName+jLib.getSystemTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		}
		catch(IOException e) {
			e.printStackTrace();
			
	}
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
	}
	
	

}
