package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

	@FindBy(xpath = "//input[@name='email']")
	WebElement usernametxtbox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordtxtbox;
	
	@FindBy(xpath = "//span[contains(text(),'Sign In')]")
	WebElement loginBtn;
	
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void doLogin(String uname , String pass) {
		
		usernametxtbox.sendKeys(uname);
		passwordtxtbox.sendKeys(pass);
		
		loginBtn.click();
	}
	
}
