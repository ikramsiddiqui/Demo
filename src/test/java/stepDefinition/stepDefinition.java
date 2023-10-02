package stepDefinition;

import common.WebHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import java.awt.*;

public class stepDefinition {

    WebHelper webHelper = new WebHelper();

    @Given("Browser is open and working properly")
    public void webBorwserIsOpenAndWorkingProperly() {
        try {
            webHelper.openBrowser();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @And("User is entering {string} in text box {string} having text box type {string}")
    public void webUserIsEnteringStringInTextBoxStringHavingTextBoxTypeString(String arg0, String arg1, String arg2) throws InterruptedException {
        webHelper.textField(arg0, arg1, arg2);
    }

    @And("User is open the page  using the url {string}")
    public void webUserIsOpenThePageUsingTheUrl(String arg0) {
        webHelper.openPage(arg0);

    }

    @When("User is clicking on button {string} having button type {string}")
    public void webUserIsClickingOnButtonHavingButtonType(String arg0, String arg1) throws InterruptedException {
        webHelper.click(arg0, arg1);
    }


    @Then("User is able to see label name {string} having label locator {string} & label locator type {string}")
    public void webUserIsAbleToSeeLabelNameHavingLabelLocatorLabelLocatorType(String arg0, String arg1, String arg2) {
        webHelper.assertEqualText(arg0, arg1, arg2);
    }

    @Then("User is able to see the title name {string} of page")
    public void webUserIsAbleToSeeTheTitleNameOfPage(String arg0) {
        webHelper.assertTitle(arg0);
    }


    @And("User is able to close the browser")
    public void userIsAbleToCloseTheBrowser() {
        webHelper.quitBrowser();
    }


    @And("User is able to see list item {int} in list {string} having list locator type {string}")
    public void userIsAbleToSeeListItemInListHavingListLocatorType(int arg0, String arg1, String arg2) {
        webHelper.verifyTheListCount(arg0,arg1,arg2);
    }
}