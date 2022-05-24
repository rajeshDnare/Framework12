package pack01;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AlertsDemoPage;
import pageObjects.LandingPage;
import resources.BaseFile;

public class TestCase01 extends BaseFile{
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(TestCase01.class.getName());
	@BeforeTest
	public void beforeTest() throws IOException {
		driver=invokeBrowser();
		log.info("Browser is invoked");
	}
	
	@Test
	public void myTest01() {
		driver.get(prop.getProperty("url01"));
		pageScrolling(0,300);
		
		LandingPage lp = new LandingPage(driver);
		AlertsDemoPage adp=lp.openNewTabButton();
		
		Set<String> wins= driver.getWindowHandles();
		Iterator<String> itr=wins.iterator();
		String parent=itr.next();
		String child=itr.next();
		driver.switchTo().window(child);
		
		
		pageScrolling(0, 200);
		adp.confirmBoxAlert().click();
		driver.switchTo().alert().accept();
		log.info("Test is completed");

	}
	
	@AfterTest
	public void afterTest01() {
		driver.quit();
		log.info("Browser is closed");
	}
	

}
