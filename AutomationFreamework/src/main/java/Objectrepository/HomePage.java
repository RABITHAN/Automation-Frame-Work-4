package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "Log out")
	private WebElement logoutlink;
	
	@FindBy(partialLinkText = "Books")
	private WebElement bookslinks;
	
	public HomePage(WebDriver  driver) {
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getlogoutLink() {
		return logoutlink;
		
	}
    public WebElement getBooksLink() {
		return getBooksLink();
    }
	
	
	
}
