package pack01;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseFile;

public class TestCase02 extends BaseFile {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(TestCase02.class.getName());
	@BeforeTest
	public void Beforetest02() throws IOException {
		driver = invokeBrowser();
		log.info("Browser is invoked");

	}
	
	@Test
	public void myTest02() {
		driver.get(prop.getProperty("url02"));
		String webTitle=driver.getTitle();
		Assert.assertEquals("Google", webTitle);
		log.info("Test is completed");
	}
	
	@AfterTest
	public void afterTest02() {
		driver.close();
		log.info("Browser is closed");
	}
	

}
