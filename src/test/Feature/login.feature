@loginNPositiveNegative
Feature: verify the logi
  @login
  Scenario Outline: To verify that user is able to login with valid credentials
    Given Browser is open and working properly
    When User is open the page  using the url "https://www.saucedemo.com/"
    And User is entering <Email_Address> in text box "user-name" having text box type "id"
    And User is entering <Password> in text box "password" having text box type "id"
    And User is clicking on button "login-button" having button type "id"
    Then User is able to see the title name "Swag Labs" of page
    And User is clicking on button "react-burger-menu-btn" having button type "id"
    And User is clicking on button "logout_sidebar_link" having button type "id"
    And User is able to close the browser

    Examples:
      |Email_Address        |Password    |
      |"standard_user"      |"secret_sauce"|

  @login
  Scenario Outline: To verify that user is able to login with valid credentials
    Given Browser is open and working properly
    When User is open the page  using the url "https://www.saucedemo.com/"
    And User is entering <Email_Address> in text box "user-name" having text box type "id"
    And User is entering <Password> in text box "password" having text box type "id"
    And User is clicking on button "login-button" having button type "id"
    Then User is able to see label name <ErrorMessage> having label locator "//h3" & label locator type "xpath"
    And User is able to close the browser

    Examples:
      |Email_Address        |Password     |       ErrorMessage                 |
      |"standard_user"      |""           |"Epic sadface: Password is required"|
      |""                   |"secret_sauce"| "Epic sadface: Username is required" |
      |"standard_user"      | "abc12312"   |"Epic sadface: Username and password do not match any user in this service"|