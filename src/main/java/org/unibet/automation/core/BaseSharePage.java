package org.unibet.automation.core;

import org.unibet.automation.pageobjects.HomePageNavigation;

public abstract class BaseSharePage {

	public SeleniumDriver driverObj;

	public BaseSharePage(SeleniumDriver driverObj) {
		this.driverObj = driverObj;
	}

	public HomePageNavigation getNavigation() {
		return new HomePageNavigation(driverObj);
	}
}