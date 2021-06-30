package TanmoyFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName,String password, String user) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		
		LandingPage hp = new LandingPage(driver);
		LoginPage lp = hp.getLogin();
		
		lp.UserId().sendKeys(userName);	
		lp.Password().sendKeys(password);
		System.out.println(user);
		log.info(user);
		lp.Login().click();
		
		ForgotPasswordPage fp = lp.ForgotPassword();
		fp.Email().sendKeys("xxx");
		fp.SendIns().click();
	}
	@Test
	public void test()
	{
		System.out.println("git push");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data type
		//column stands for how many value in each steps
		Object[][] obj = new Object[2][3];
		
		//1st set
		obj[0][0] = "nonRestrictedUser";
		obj[0][1] = "12345";
		obj[0][2] = "Non Restricted User";
		//2nd set
		obj[1][0] = "restrictedUser";
		obj[1][1] = "123456";
		obj[1][2] = "Restricted User";
		
		return obj;
	}
	
}
