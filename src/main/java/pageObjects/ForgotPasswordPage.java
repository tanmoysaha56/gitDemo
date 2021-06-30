package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage 
{
	public WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By email = By.id("user_email");
	private By sendIns = By.cssSelector(".btn.btn-primary.btn-md.login-button");
	
	public WebElement Email()
	{
		return driver.findElement(email);
	}
	public WebElement SendIns()
	{
		return driver.findElement(sendIns);
	}
}
