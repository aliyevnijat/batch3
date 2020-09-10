package com.example.selenium.steps;

import com.example.selenium.pages.ShopNewPage;
import io.cucumber.java.en.*;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopNewSteps {

    @Autowired
    private ShopNewPage shopNewPage;

    @Given("I shop for a new car")
    public void i_shop_for_a_car() {
        shopNewPage.shopNewSearch.click();
    }

    @Then("I should see {int} car makes")
    public void i_should_see_car_makes(int numMakes) {
        List<WebElement> carMakes = shopNewPage.carMakes;
        assertEquals(numMakes, carMakes.size());

    }

    @When("I click on make {string}")
    public void clickOnMake(String make) {
        List<WebElement> carMakes = shopNewPage.carMakes;
        for (WebElement el : carMakes) {
            if (el.getText().equalsIgnoreCase(make)) {
                el.click();
                break;
            }

        }
    }

    @Then("I should see car models {string}")
    public void i_should_see_car(String models) {
        String modelsExpected [] = models.split(",");
        List <String> actualModelList=shopNewPage.modelNamesString();
        for (int i = 0; i <modelsExpected.length ; i++) {
            String strmodels = actualModelList.get(i);
            String [] actualModels=strmodels.split("\n");
            assertEquals(modelsExpected[i],actualModels[0]);
        }


    }

    @Then("I click on Body Type")
    public void iClickOnBodyType() {
        shopNewPage.bodyType.click();

    }

    @And("I choose body type {string}")
    public void iChooseBodyType(String bodyType) {
        shopNewPage.chooseBodyType(bodyType);
    }

    @Then("I should see {int} cars")
    public void i_should_see_cars(int numOfCars) {
        int actualNumOfCars = shopNewPage.numberOfCarsForTheGivenBodyType.size();
        Assert.assertEquals(numOfCars,actualNumOfCars);
    }



}
