package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	By userName=By.xpath("//input[@id='username']");
	By userPassword=By.xpath("//input[@id='password']");
	By loginButton=By.xpath("//input[@id='login']");
	
	
	public void enterUserName(String name) {
		
		driver.findElement(userName).sendKeys(name);
	}
	
	public void enterUserPassword(String password) {
		driver.findElement(userPassword).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
