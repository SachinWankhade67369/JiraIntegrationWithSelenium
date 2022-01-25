package com.utility;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {

	public JiraClient jiraClient;
	public String project;

	public JiraServiceProvider(String jiraUrl, String username, String password, String project) {

		BasicCredentials creds = new BasicCredentials(username, password);
		jiraClient = new JiraClient(jiraUrl, creds);

		this.project = project;

	}

	public void createJiraTicket(String issueType, String summary, String description, String repoterName) {

		try {
			FluentCreate fluentCreate = jiraClient.createIssue(project, issueType);

			// here we can add multiple feild of issue like summery,description, reporter, epic,
			fluentCreate.field(Field.SUMMARY, summary);
			fluentCreate.field(Field.DESCRIPTION, description);
			Issue newIssue = fluentCreate.execute();
			System.out.println("New issue create in Jira with ID: " + newIssue);

		} catch (JiraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
