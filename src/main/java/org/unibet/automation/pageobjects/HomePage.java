package org.unibet.automation.pageobjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unibet.automation.core.BaseSharePage;
import org.unibet.automation.core.SeleniumDriver;

/**
 * @author shiva
 * This class is for the Home page object. 
 */
public class HomePage extends BaseSharePage{
	private static Log logger = LogFactory.getLog(HomePage.class);

	public HomePage(SeleniumDriver driverObj) {
		super(driverObj);
		logger.info("Accessing UniBet HomePage");
	}
}