package com.example.selenium.steps;

import com.example.selenium.pages.NewCarBodyTypePage;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

public class NewCarsBodyTypeSteps {
    @Autowired
    public NewCarBodyTypePage newCarBodyTypePage;
    @Given("i am on the home page and clicking for shop new")
    public void i_am_on_the_home_page_and_clicking_for_shop_new() {
        newCarBodyTypePage.shopNewSearch.click();
    }

    @When("i am choosing body type in new page")
    public void i_am_choosing_body_type_in_new_page() {
      newCarBodyTypePage.bodytype.click();
    }

    @Then("i have to verify {int} body types there")
    public void i_have_to_verify_body_types_there(int expectednumber) {
     newCarBodyTypePage.assertionprocess(expectednumber);
    }

}
