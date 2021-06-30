package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By id = By.id("user_email");
	private By password = By.id("user_password");
	
	private By login = By.xpath("//input[@type='submit']");
	private By forgotPassword = By.cssSelector("a[class='link-below-button']");
	
	public WebElement UserId()
	{
		return driver.findElement(id);
	}
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	public WebElement Login()
	{
		return driver.findElement(login);
	}
	public ForgotPasswordPage ForgotPassword()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPage(driver);
	}
	
	
}
