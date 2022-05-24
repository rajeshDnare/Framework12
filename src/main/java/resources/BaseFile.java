package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseFile {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver invokeBrowser() throws IOException {
		String basePath=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(basePath+"\\src\\main\\java\\resources\\data.properties");
		prop=new Properties();
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if(browser.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			if(browser.contains("headless")) {
				options.addArguments("HEADLESS");
			}
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			System.out.println("Invalid browser name");
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public void pageScrolling(int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public String getScreenshot(WebDriver driver, String methodName) throws IOException {
		File myScreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String basePath=System.getProperty("user.dir");
		String screenCapturedPath=basePath+"\\reports\\"+methodName+".jpg";
		FileUtils.copyFile((myScreen),  new File(screenCapturedPath));
		return screenCapturedPath;
	}

}
