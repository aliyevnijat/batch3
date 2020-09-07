package com.example.selenium.steps;

import com.example.selenium.pages.ModelComparisionPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class MakecompareSteps {
    @Autowired
    public ModelComparisionPage modelComparisionPage;

    @When("i am on the home page and clicking on MAkecomaprision")
    public void i_am_on_the_home_page_and_clicking_on_MAkecomaprision() {
        modelComparisionPage.modelcompare.click();
        modelComparisionPage.sleep(2);
    }

    @When("i am selecting {string} and {string}")
    public void i_am_selecting_and(String makes, String models) {
        String[] arr1=makes.split(",");
        String[] arr2=models.split(",");
       Select select1=new Select(modelComparisionPage.field1);
       select1.selectByVisibleText(arr1[0]);
       modelComparisionPage.sleep(1);
        Select select2=new Select(modelComparisionPage.field2);
        select2.selectByVisibleText(arr2[0]);
        modelComparisionPage.sleep(1);
        Select select3=new Select(modelComparisionPage.field3);
        select3.selectByVisibleText(arr1[1]);
        modelComparisionPage.sleep(1);
        Select select4=new Select(modelComparisionPage.field4);
        select4.selectByVisibleText(arr2[1]);
    }

    @When("i am clicking on compare")
    public void i_am_clicking_on_compare() {
      modelComparisionPage.compbutton.click();
      modelComparisionPage.sleep(2);
    }

    @Then("i have to verify shown text on top")
    public void i_have_to_verify_shown_text_top() {
        String expected=modelComparisionPage.shownText.getText();
        Assert.assertEquals(expected,modelComparisionPage.shownText.getText());

    }

}
