package org.unibet.automation.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.unibet.automation.core.BaseSharePage;
import org.unibet.automation.core.SeleniumDriver;

/**
 * @author shiva
 * This class is for the searchResults page object. 
 */
public class SearchResultsPage extends BaseSharePage{
	private static Log logger = LogFactory.getLog(SearchResultsPage.class);
	
	private static final By NO_RESULTS_FOUND_SELECTOR = By.cssSelector("div.gs-no-results-result");
	private static final By RESULTS_LIST_SELECTOR = By.cssSelector("td a.gs-title");
	
	
	public SearchResultsPage(SeleniumDriver driverObj) {
		super(driverObj);
		logger.info("Accessing Search Results Page.");
	}
	
	public List<String> getResultAsStringValues() {
		List<String> results = new ArrayList<String>();
		try {
			for (WebElement resultItem : driverObj.findAndWaitForAll(RESULTS_LIST_SELECTOR)) {
				results.add(resultItem.getText());
			}
			
			logger.info("UniBet Search Results page loded successfully.");
			
		} catch (TimeoutException te) {
			logger.warn("No Results Found");
		}
		return results;
	}
	
	public boolean isNoResultsMessageFound(){
		try{
			return driverObj.findAndWait(NO_RESULTS_FOUND_SELECTOR,5000).isDisplayed();
		}catch(TimeoutException te){
			return false;
		}
	}

}
