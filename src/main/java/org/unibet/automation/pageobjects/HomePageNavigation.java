package org.unibet.automation.pageobjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.unibet.automation.core.SeleniumDriver;

/**
 * @author shiva
 * This class is for the Home page navigation page object. 
 */
public class HomePageNavigation{
	private static Log logger = LogFactory.getLog(HomePageNavigation.class);

	private static final String SEARCH_HOVER_XPATH_LOCATOR = ".//a[@class='search hover-intent']";
	private static final By SEARCH_BUTTON_SELECTOR = By.cssSelector("input[value='Search']");
	private static final By SEARCH_BOX_LOCATOR = By.id("cse-search-input-box-id");
	
	private SeleniumDriver driverObj;
	
	public HomePageNavigation(SeleniumDriver driverObj)
	{
		logger.info("Accessing HomePage Navigation");
		this.driverObj = driverObj;
	}
	
	public void enterSearchText(String searchText)
	{
		driverObj.mouseOver(SEARCH_HOVER_XPATH_LOCATOR);
		driverObj.waitUntilElementDisplayed(SEARCH_BOX_LOCATOR);
		driverObj.find(SEARCH_BOX_LOCATOR).sendKeys(searchText);
		logger.info("Entered Search Text as : " + searchText);
	}
	
	public SearchResultsPage clickSearchButton()
	{
		driverObj.findAndWait(SEARCH_BUTTON_SELECTOR).click();
		return new SearchResultsPage(driverObj);
	}
	
	
}
