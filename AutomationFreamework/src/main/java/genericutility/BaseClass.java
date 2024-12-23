package genericutility;

import java.io.IOException;

import java.sql.Driver;
import java.time.Duration;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Objectrepository.HomePage;
import Objectrepository.LoginPage;
import Objectrepository.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extreports;
	public static ExtentTest test;
	
	
	
   public static ExtentReports extRepots;
   
   public JavaUtility jLib=new JavaUtility();
private Object flib;
   
   @BeforeSuite
   public void reportconfig() {
	   ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/"+jLib.getSystemTime()+".html");
	   extreports=new ExtentReports();
	   extreports.attachReporter(spark);
   }
   
   @Parameters("Browser")
   @BeforeClass
   
   public void lauchBrowser(@Optional ("chrome") String browserName) throws IOException {

	   
	if (browserName.equalsIgnoreCase("chrome")) {

	   driver =new ChromeDriver();

	   }else if (browserName.equalsIgnoreCase("firefox")) {

	   driver=new FirefoxDriver();

	   }else if (browserName.equalsIgnoreCase("edge")) {

	   driver=new EdgeDriver();

	   }

	   driver.manage().window().maximize();

	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (20));

	   driver.get(FLip.getDataFromProperty("url"));

	   }

	   @BeforeMethod

	   public void login() throws IOException {

	  wp = new WelcomePage(driver);

	   wp.getLoginLink().click();

	   1p=new LoginPage(driver);

	   1p.getEmailTextField().sendKeys(flib.getDataFromProperty("email"));


	   1p.getLoginButton().click();

	   }
	   
	   @AfterMethod

	   public void logout() {

	   hp=new HomePage(driver);

	   hp.getLogoutLink().click();

	   }
	   @AfterClass

	   public void closeBrowser() {

	   driver.quit();

	   }
   
   @AfterSuite
   public void reportBackup() {
	   extreports.flush();
	   
   }
	
}
