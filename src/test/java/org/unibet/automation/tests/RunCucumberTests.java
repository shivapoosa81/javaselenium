package org.unibet.automation.tests;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(tags = { "@search" }, format = { "pretty",
		"html:target/cucumber-htmlreport",
		"json-pretty:target/cucumber-report.json" })
public class RunCucumberTests {
}