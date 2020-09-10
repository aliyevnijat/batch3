package com.example.selenium.steps;

import com.example.selenium.pages.ShopUsedPage;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopUsedSteps {

    @Autowired
    public ShopUsedPage shopUsedPage;

    @Given("I shop for used car")
    public void i_shop_for_used_car() {
       shopUsedPage.shopUsedSearch.click();
    }

    @Then("I search for {string}")
    public void i_search_for(String make) {

    }

}
