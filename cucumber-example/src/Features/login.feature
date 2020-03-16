Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login whit correct username and password
    Given I navigate to the login page
    And I enter the username as "admin" and password as "adminpassword"
    And I enter the following login
    |userName|password|
    |user1   |12345   |
    |user2   |123456  |
    |user3   |1234567 |
    And I click login button
    Then I should see the userform page
