Feature: ContactUs Page

  Scenario: Validate Successful Submission
    Given I access the University Contact Us Page
    When I enter a first name
    And I enter a last name
    And I enter an email address
    And I enter a comment
    And I click on the submit button
    Then I should be  presented with a successful Contact Us submission message