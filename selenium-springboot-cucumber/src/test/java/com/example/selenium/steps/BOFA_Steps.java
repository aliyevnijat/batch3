package com.example.selenium.steps;

import com.example.selenium.pages.BOFA_Page;
import com.example.selenium.runners.Hook;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;

public class BOFA_Steps {
    @Autowired
    public BOFA_Page bofa_page;
    @Autowired
    private Hook hook;


    @When("Click on Location \\(bottom of the page)")
    public void click_on_Location_bottom_of_the_page() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)hook.getDriver();
        js.executeScript("window.scrollBy(0,450)","");
            bofa_page.location.click();
            Thread.sleep(2000);
    }

    @When("Verify location page is displayed")
    public void verify_location_page_is_displayed() {
             String expected = "Found";
        Assert.assertTrue(bofa_page.shown_Text.getText().contains(expected));
    }

    @When("Navigate back")
    public void navigate_back() throws InterruptedException {
        bofa_page.BOFA_Logo.click();
        Thread.sleep(4000);

    }

    @When("Click on Contact Us")
    public void click_on_Contact_Us() throws InterruptedException {

        JavascriptExecutor js=(JavascriptExecutor)hook.getDriver();
        js.executeScript("window.scrollBy(0,450)","");
          bofa_page.Contact_us.click();
          Thread.sleep(2000);
    }

    @Then("Verify Contact Us page is displayed")
    public void verify_Contact_Us_page_is_displayed() {
        String expected="Bank of America Customer Service";
          Assert.assertEquals(expected,bofa_page.customer_servicetext.getText());
    }
    @When("Go to bank of amewrica website")
    public void go_to_bank_of_amewrica_website() throws InterruptedException {
        bofa_page.BOFA_Logo.click();
        Thread.sleep(2000);
    }


    @Then("Highlight Savings then click on that")
    public void highlight_Savings_then_click_on_that() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) hook.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", bofa_page.Savings);
        Thread.sleep(2000);
        bofa_page.Savings.click();
    }

}
