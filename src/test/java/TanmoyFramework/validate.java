package TanmoyFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class validate extends base
{
	LandingPage lp;
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to page");
	}
	@Test
	public void basePageNavigation() throws IOException
	{
		lp = new LandingPage(driver);
		
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		
		Assert.assertTrue(lp.getNavigation().isDisplayed());
		log.info("Successfully validated");
	}
	
	@Test
	public void validateBannerTitle() throws IOException
	{
		Assert.assertEquals(lp.getBanner().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("successfully validated banner");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
