package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsDemoPage {
	public WebDriver driver;

	public AlertsDemoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button#confirmBox")
	WebElement confirmBoxAlert;
	
	public WebElement confirmBoxAlert() {
		return confirmBoxAlert;
	}
	
	
	

}
