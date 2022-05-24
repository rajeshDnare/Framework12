package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By openNewTabButton=By.cssSelector("button#newTabBtn");
	
	public AlertsDemoPage openNewTabButton(){
		driver.findElement(openNewTabButton).click();
		return new AlertsDemoPage(driver);
	}
	
	
}
