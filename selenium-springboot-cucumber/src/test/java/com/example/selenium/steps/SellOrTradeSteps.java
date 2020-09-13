package com.example.selenium.steps;

import com.example.selenium.pages.SellOrTradePage;
import com.example.selenium.runners.Hook;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

public class SellOrTradeSteps {
    @Autowired
    private SellOrTradePage sellOrTradePage;


    @Given("I click on sell or trade")
    public void i_click_on_sell_or_trade() {
        sellOrTradePage.sellOrTrade.click();
    }

    @When("I input licence or plate {string} and select state {string}")
    public void iInputLicenceOrPlateAndSelectState(String licence, String state) throws InterruptedException {
        Thread.sleep(2000);
        sellOrTradePage.licensePlate.sendKeys(licence);
        sellOrTradePage.selectState(state);
        Thread.sleep(2000);
    }
}
