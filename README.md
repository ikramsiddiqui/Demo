# Demo
Keyword Driven Selenium Framework using Gherkin
Overview

This framework is designed for automated testing using Selenium 4 with a Keyword Driven approach and Gherkin language for writing test scenarios. In this framework, we organize test cases using a BDD (Behavior-Driven Development) style, making it easy to manage and execute tests. Additionally, we promote reusability by creating separate functions for interacting with each web element present on our website.

How to Run 

Prerequisites:

Before running the tests, ensure you have the following:

Java Development Kit (JDK) installed
Maven installed
WebDriver executables (e.g., ChromeDriver) available and configured in your system's PATH
A code editor or IDE (e.g., IntelliJ IDEA, Visual Studio Code)

Creating Feature Files
Create your feature files using Gherkin syntax. Feature files describe test scenarios in a human-readable format.

Define your test steps based on the actions you want to perform on your web application.

Step Definitions
Implement step definitions for your feature files. Each step in your feature file should have a corresponding step definition method in your code.

Use the following step definition methods for common actions:

Opening the Browser:
Given Browser is open and working properly

Opening a Page:
User is open the page using the URL "https://www.saucedemo.com/"

Entering Text:
User is entering "{text}" in text box "{locator}" having text box type "{locatorType}"

Clicking a Button:
User is clicking on button "{locator}" having button type "{locatorType}"

Verifying Page Title:
User is able to see the title name "{page title}"

Verifying Text:
User is able to see label name "{verify text}" having label locator "{locator}" & label locator type "{locatorType}"

Verifying List Count:
User is able to see list item count in list "{locator}" having list locator type "{locatorType}"

Closing the Browser:
User is able to close the browser

Running Tests:

To run your tests, you can use a test runner class. You can also specify tags in your feature files to run specific scenarios or features.
Execute the tests using the provided test runner class or a tool like Maven, which can run tests defined in the feature files.
        mvn test

Viewing Test Reports
After running the tests, Allure reports will be generated. Install Allure on your PC, and you can use the following command to serve and view the reports:
             allure serve target/allure-results
Capturing Screenshots on Test Failure
In case of test failures, screenshots will be captured and stored in the "image" folder with the current date for reference.


Contact:

For questions, issues, or feedback, please contact Your Name.

