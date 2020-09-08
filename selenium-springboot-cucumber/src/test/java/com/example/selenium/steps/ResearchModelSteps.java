package com.example.selenium.steps;

import com.example.selenium.pages.ResearchModelPage;
import com.example.selenium.pages.SellOrTradePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class ResearchModelSteps {

    @Autowired
    private ResearchModelPage researchModelPage;

    @Given("click on Research")
    public void click_on_Research() {
        researchModelPage.research.click();
    }

    @When("select make {string} and  model {string}")
    public void select_make_and_model(String make, String model) throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(researchModelPage.selectMake);
        select.selectByVisibleText(make);
        Thread.sleep(1500);
        Select select1 = new Select(researchModelPage.selectModel);
        select1.selectByVisibleText(model);
        researchModelPage.GO.click();

    }

    @When("verify header {string}on new page")
    public void verify_header_on_new_page(String string) throws InterruptedException {
        Thread.sleep(3000);
      Assert.assertEquals(string,researchModelPage.header.getText());
    }


}
