package com.example.selenium.steps;

import com.example.selenium.pages.EtsyexplorePage;
import com.example.selenium.runners.Hook;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.*;

import java.util.Set;

public class EtsyExploreSteps {
    @Autowired
    public EtsyexplorePage etsyexplorePage;

    @Autowired
    private Hook hook;


    @When("i am on home page i have to verify tittle of the page")
    public void i_am_on_home_page_i_have_to_verify_tittle_of_the_page() {
        String expected="Find things you'll love. Support independent sellers. Only on Etsy.";
        Assert.assertEquals(expected,etsyexplorePage.shownText.getText());
    }
    @Then("i go for search and send send iphone case")
    public void i_go_for_search_and_send_send() throws InterruptedException {
        etsyexplorePage.search.sendKeys("iphone case");
        Thread.sleep(1000);
        etsyexplorePage.searchclick.click();
        Thread.sleep(3000);
//        if (etsyexplorePage.Filter.isDisplayed()){
//            etsyexplorePage.Filter.click();
//            Thread.sleep(1000);
//            etsyexplorePage.Free_Sipping_Filter.click();
//            Thread.sleep(2000);
//
//        }
    }

    @Then("verify All categories contains search item")
    public void verify_All_categories_contains_search_item() {
       String expected="iphone case";
       Assert.assertEquals(expected,etsyexplorePage.searchitemtext.getText());
    }
 

    @Then("verify  default value is Any price")
    public void verify_default_value_is_Any_price() {
        String actual=etsyexplorePage.AnyPrice.getAttribute("checked");
        System.out.println(actual);
        Assert.assertEquals("true",actual);
    }



    @Then("select Free shipping")
    public void select_Free_shipping() {
       etsyexplorePage.FreeShipping.click();
    }


    @Then("verify ship to default value is {string}")
    public void verify_ship_to_default_value_is(String expectedDefaultCountry) {
       Select select=new Select(etsyexplorePage.ShiptoText);
        WebElement option=select.getFirstSelectedOption();
        String actual =option.getText();
        Assert.assertEquals(expectedDefaultCountry.trim(),actual.trim());

    }


    @Then("select diffrent {string}")
    public void select_diffrent(String diffcountry) {
        Select select =new Select(etsyexplorePage.ShiptoText1);
        diffcountry="Australia";
        select.selectByVisibleText(diffcountry);

    }


    @Then("Select first item from search result")
    public void select_first_item_from_search_result() throws InterruptedException {
        String firsttab=hook.getDriver().getWindowHandle();
        etsyexplorePage.Firstitem.click();
        Thread.sleep(2000);
       Set <String> tabs=hook.getDriver().getWindowHandles();
        for (String tab:tabs) {
            if (!tab.equalsIgnoreCase(firsttab)){
                hook.getDriver().switchTo().window(tab);
            }
        }



    }

//    @Then("Select Device is {string} and Customize is {string}")
//    public void select_Device_is_and_Customize_is(String Device, String Customise) {
//        Select select1=new Select(etsyexplorePage.Device);
//        select1.selectByVisibleText(Device);
//        Select select2=new Select(etsyexplorePage.Customize);
//        select2.selectByVisibleText(Customise);
//
//    }



//    @Then("add item to the cart")
//    public void add_item_to_the_cart() throws InterruptedException {
//      etsyexplorePage.AddToCart.click();
//      Thread.sleep(3000);
//    }

//    @Then("Verify Your aitem is added to the cart")
//    public void verify_Your_aitem_is_added_to_the_cart() throws InterruptedException {
//        etsyexplorePage.CartLogo.click();
//        Thread.sleep(3000);
//        String expected="1 item in your cart";
//        Assert.assertEquals(expected.trim(),etsyexplorePage.ShownText.getText().trim());
//    }


    @Then("Verify Your item is free with shown text {string} contains whole text")
    public void verify_Your_item_is_free_with_shown_text_contains_whole_text(String showntext) {
        Assert.assertTrue(etsyexplorePage.Showntext_below.getText().contains(showntext));
    }





}
