package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerObjects {
	WebDriver driver;

	public DatePickerObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#from")
	WebElement fromTxtBox;

	public WebElement firstTxtBox() {
		return fromTxtBox;
	}

	@FindBy(css = "select.ui-datepicker-month")
	WebElement selectMonth;

	public WebElement selectMonth() {
		return selectMonth;
	}
	
	@FindBy(css = "iframe.demo-frame")
	WebElement frame01;

	public WebElement frame01() {
		return frame01;
	}
	
	
	
	@FindBy(css = "div[class='ui-datepicker-group ui-datepicker-group-first'] table tbody tr td a")
	List<WebElement> datesFrom;

	public List<WebElement> datesFrom() {
		return datesFrom;
	}
	
	@FindBy(css = "input#to")
	WebElement toTextBox;
	
	public WebElement toTextBox() {
		return toTextBox;
	}
	
	@FindBy(css = "select.ui-datepicker-month")
	WebElement selectToMonth;
	
	public WebElement selectToMonth() {
		return selectToMonth;
	}
	
	@FindBy(css = "div[class='ui-datepicker-group ui-datepicker-group-first'] table tbody tr td a")
	List<WebElement> datesTo;
	
	public List<WebElement> datesTo() {
		return datesTo;
	}
	
	
}
