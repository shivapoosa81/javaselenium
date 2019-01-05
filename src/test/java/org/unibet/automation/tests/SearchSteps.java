package org.unibet.automation.tests;

import junit.framework.Assert;

import org.unibet.automation.pageobjects.HomePage;
import org.unibet.automation.pageobjects.HomePageNavigation;
import org.unibet.automation.pageobjects.SearchResultsPage;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class SearchSteps extends AbstractTest{
	
	private HomePage homePage;
	private HomePageNavigation navigation;
	private SearchResultsPage resultsPage;
	
	@Given("^User on UniBet Page$")
	public void User_on_UniBet_Page() throws Throwable {
		getSeleniumDriver();
	    homePage = getUniBetHomePage();
	}

	@When("^Search with \"([^\"]*)\" term$")
	public void Search_with_term(String searchItem) throws Throwable {
	    navigation = homePage.getNavigation();
		navigation.enterSearchText(searchItem);
	    resultsPage = navigation.clickSearchButton();
	}

	@Then("^List of Results will be displayed$")
	public void List_of_Results_will_be_displayed(){
	    Assert.assertFalse(resultsPage.isNoResultsMessageFound());
	    Assert.assertTrue(resultsPage.getResultAsStringValues().size()>0);
	}

	@Then("^No results should be displayed$")
	public void No_results_should_be_displayed() throws Throwable {
	    Assert.assertTrue(resultsPage.isNoResultsMessageFound());
	}
}
