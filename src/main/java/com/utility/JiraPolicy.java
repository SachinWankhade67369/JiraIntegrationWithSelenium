package com.utility;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * 
 * @author sachinw
 * 
 * To create annotation in java, just need to create interface along with @ notation like @interface
 * We can create user-define annotation with the help of RetentionPocily.
 * I want use this particular annotation at runtime hence RetentionPolicy.RUNTIME will 
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface JiraPolicy {

	// Have to maintain one boolean flag
	boolean logTicketReady();
}
