Feature: User want to add or remove thr item in cart
  Scenario: USer is able to login on the page
    Given Browser is open and working properly
    When User is open the page  using the url "https://www.saucedemo.com/"
    And User is entering "standard_user" in text box "user-name" having text box type "id"
    And User is entering "secret_sauce" in text box "password" having text box type "id"
    And User is clicking on button "login-button" having button type "id"

  Scenario: User is able to add the item in the cart  anc purchase the item sucessfully
    Given User is clicking on button "add-to-cart-sauce-labs-backpack" having button type "id"
    And  User is clicking on button "shopping_cart_badge" having button type "classname"
    And User is able to see list item 1 in list "cart_item" having list locator type "classname"
    And User is clicking on button "checkout" having button type "id"
    Then User is able to see label name "Checkout: Your Information" having label locator "title" & label locator type "classname"
    And User is entering "secret_sauce" in text box "first-name" having text box type "id"
    And User is entering "secret_sauce" in text box "last-name" having text box type "id"
    And User is entering "secret_sauce" in text box "postal-code" having text box type "id"
    And User is clicking on button "continue" having button type "id"
    Then User is able to see label name "Checkout: Overview" having label locator "title" & label locator type "classname"
    And User is clicking on button "finish" having button type "id"
    Then User is able to see label name "Thank you for your order!" having label locator "complete-header" & label locator type "classname"
   And  User is able to close the browser

