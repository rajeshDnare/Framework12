package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageURL03 {
	WebDriver driver;

	public LoginPageURL03(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#username")
	WebElement userName;
	
	public WebElement userName() {
		return userName;
	}
	
	@FindBy(css="input#password")
	WebElement password;
	
	public WebElement password() {
		return password;
	}
	
	@FindBy(css="input#signInBtn")
	WebElement signingButton;
	
	public WebElement signingButton() {
		return signingButton;
	}
	
	
	
	
	
}
