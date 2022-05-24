package pack01;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UIKeywords.Keywords;
import pageObjects.DatePickerObjects;
import resources.BaseFile;

public class DatePickerTest extends BaseFile{
	WebDriver driver;
	
	@BeforeTest
	public void beforeTestDatePicker() throws IOException {
		driver=invokeBrowser();
		
	}
	
	@Test
	public void datePicker() throws InterruptedException  {
		driver.get(prop.getProperty("url04"));
		DatePickerObjects dp = new DatePickerObjects(driver);
		driver.switchTo().frame(dp.frame01());
		dp.firstTxtBox().click();
		
		Keywords.selectOption(dp.selectMonth(), "Sep");
		
		List<WebElement> fromDates=dp.datesFrom();
		Keywords.iterateAndSelect(fromDates, "25");
		
		dp.toTextBox().click();
		
		Keywords.selectOption(dp.selectToMonth(), "Oct");
		
		List<WebElement> toDates=dp.datesTo();
		Keywords.iterateAndSelect(toDates, "27");
		
		System.out.println(dp.firstTxtBox().getText());
		System.out.println(dp.toTextBox().getText());
		
	}
	
	@AfterTest
	public void afterTestDatePicker() {
		driver.close();
		
	}

}
