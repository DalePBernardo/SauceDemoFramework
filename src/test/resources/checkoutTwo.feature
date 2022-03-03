Feature: Able to verify personal details and navigate to different pages on the website

  Background: Setting up the Browser
    Given I am on the Checkout Two page

  Scenario: Getting to the Checkout Complete page from the Checkout Two page
    When I click on the finish button
    Then I will go to the checkout complete page

  Scenario: Getting to the Inventory page via cancel button from the Checkout Two page
    When I click on cancel button
    Then I will go to the Inventory page

  Scenario: Getting to the Your Cart page via cart icon from the Checkout Two page
    When I click on Cart icon
    Then I will go to the Your Cart page

  Scenario: Getting to the Twitter page from the Checkout One page
    When I click on Twitter icon
    Then I will go to the Twitter page

  Scenario: Getting to the Facebook page from the Checkout One page
    When I click on Facebook icon
    Then I will go to the Facebook page

  Scenario: Getting to the Linkedin page from the Checkout One page
    When I click on Linkedin icon
    Then I will go to the Linkedin page
