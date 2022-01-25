package com.listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utility.JiraPolicy;
import com.utility.JiraServiceProvider;

public class TestJiraListeners implements ITestListener {

	public void onTestFailure(ITestResult result) {

		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);

		boolean isTicketReady = jiraPolicy.logTicketReady();

		// we have to control on jira to create unnecessary issue so we need to create and maintain 
		// boolean flag with the help of logTicketReady = true; 
		if (isTicketReady) {

			// raise jira ticket:
			System.out.println("is Ticket ready for jira: +" + isTicketReady);

			// CON is short form of project name CONSUMER Board
			JiraServiceProvider jiraSP = new JiraServiceProvider("https://adgiants.atlassian.net/",
					"sachin.wankhade@synerzip.com", "MailPassword", "CON");

			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()
					+ " got failed due to some assertion or exeception.";
			String issueDescription = result.getThrowable().getMessage() + "\n";
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

			jiraSP.createJiraTicket("Bug", issueSummary, issueDescription, "Sachin");
		}

	}
}
