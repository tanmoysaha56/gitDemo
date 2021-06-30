package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base 
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException 
	{
		prop = new Properties();
		//System.getProperty("user.dir") - project path
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		 
		String browserName = System.getProperty("browser");	//to pass browser name from maven (mvn test -Dbrowser=chrome
		//String browserName = prop.getProperty("browser");
		
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
				{
					options.addArguments("headless");
				}
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot st = (TakesScreenshot)driver;
		File source = st.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destination));
		return destination;
		
	}

}
