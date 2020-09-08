package com.example.selenium.steps;

import com.example.selenium.pages.SellOrTradePage;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

public class SellOrTradeSteps {

    @Autowired
    private SellOrTradePage sellOrTradePage;

    @Given("a User clicks on Sell or Trade")
    public void a_User_clicks_on_Sell_or_Trade() {
        sellOrTradePage.sellOrTrade.click();
    }

    @When("I input license plate number {string}")
    public void iInputLicensePlate(String license) throws InterruptedException {
        Thread.sleep(3000);
       sellOrTradePage.licensePlate.sendKeys(license);
    }

    @Then("I select state {string}")
    public void i_select_state(String state) {
        sellOrTradePage.selectState(state);
    }

    @And("the user clicks get started")
    public void the_user_clicks_get_started() {
        sellOrTradePage.getStarted.click();

    }

}
