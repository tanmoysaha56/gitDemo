package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By signin = By.xpath("//div[@class='container-fluid']/nav/ul/li[4]/a");
	private By title = By.xpath("//h2[text()='Featured Courses']");
	private By navigationBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By banner = By.cssSelector("div[class*='video-banner'] h3");
	
	public LoginPage getLogin()
	{
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigation()
	{
		return driver.findElement(navigationBar);
	}
	public WebElement getBanner()
	{
		return driver.findElement(banner);
	}
	

}
