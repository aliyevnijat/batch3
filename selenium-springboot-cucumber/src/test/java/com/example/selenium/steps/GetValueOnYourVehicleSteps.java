package com.example.selenium.steps;

import com.example.selenium.pages.GetValoueOnYourVehiclePAge;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

public class GetValueOnYourVehicleSteps {
    @Autowired
    public GetValoueOnYourVehiclePAge getValoueOnYourVehiclePAge;

    @Given("iam on home page and clicking on get value on your current vehicle")
    public void iam_on_home_page_and_clicking_on_get_value_on_your_current_vehicle() throws InterruptedException {
        getValoueOnYourVehiclePAge.tradeButton.click();
        Thread.sleep(2000);
    }

    @When("i am clicking on make and model section")
    public void i_am_clicking_on_make_and_model_section() throws InterruptedException {
        getValoueOnYourVehiclePAge.Make_Model.click();

    }

    @When("i am choosing {string} , {string},{string},{string}")
    public void i_am_choosing(String years, String makes, String models, String styles) throws InterruptedException {
       getValoueOnYourVehiclePAge.SelecTGivenData(years,makes,models,styles);

    }
    @Then("i am clicking on Get Started")
    public void i_am_clicking_on_Get_Started() throws InterruptedException {
      getValoueOnYourVehiclePAge.GetStarted.click();
      Thread.sleep(2000);
    }



}
