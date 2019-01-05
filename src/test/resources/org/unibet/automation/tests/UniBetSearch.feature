@search
Feature: Search Functionality

Background: User should be on UniBet home page
Given User on UniBet Page

Scenario Outline: Advanced Search in UniBet
When Search with "<searchItem>" term
Then List of Results will be displayed
Examples:
|searchItem|
|Unibet|
|english|

Scenario Outline: Search with special and numbers with no results found in UniBet
When Search with "<searchItem>" term
Then No results should be displayed
Examples:
|searchItem|
|£$%^&*(|
|1234567890|