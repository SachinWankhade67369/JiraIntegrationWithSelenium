package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.Base;
import com.Pages.LoginPage;
import com.utility.JiraPolicy;

public class LoginTest extends Base{
	
	public LoginPage loginPage;
	
	// calling user-define annotation to raised jira ticket/issue
	@JiraPolicy(logTicketReady = true) 
	@Test(priority = 1, enabled = true)
	public void validateLoginPagetitle() {
		
		launchDriverBrowser();
		loginPage = new LoginPage();
		String act_title = loginPage.getPageTitle();
		Assert.assertEquals(act_title, "Ad Giants > Login XXXX");
		
	}
	
	// will not raised issue for this test case as logTicketReady = false
	@JiraPolicy(logTicketReady = false) 
	@Test(priority = 2, enabled = true)
	public void validateSuccessfulLoginToApplication() {
		
		launchDriverBrowser();
		loginPage = new LoginPage();
		loginPage.doLogin("sachinwankhade.it@gmail.com", "Test@123");
		String act_title = loginPage.getPageTitle();
		Assert.assertEquals(act_title, "Ad Giants > Home");
		
	}

}
