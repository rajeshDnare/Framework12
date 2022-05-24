package pack01;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPageURL03;
import resources.BaseFile;

public class TestCase03 extends BaseFile{
	WebDriver driver;
	
	public static Logger log=LogManager.getLogger(TestCase02.class.getName());
	@BeforeTest
	public void beforeTest03() throws IOException {
		driver=invokeBrowser();
		log.info("Browser is invoked");
	}
	
	@Test
	public void myTest03() {
		driver.get(prop.getProperty("url03"));
		LoginPageURL03 a=new LoginPageURL03(driver);
		a.userName().sendKeys("rahulshettyacademy");
		a.password().sendKeys("learning");
		a.signingButton().click();
//		Assert.assertTrue(false);
		
	}
	
	@AfterTest
	public void afterTest03() {
		driver.close();
		log.info("Browser is closed");
	}
	

}
