package com.example.selenium.steps;

import com.example.selenium.helpers.Utilities;
import com.example.selenium.pages.EtsyHomePage;
import com.example.selenium.runners.Hook;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class EtsyStepDefs {

    @Autowired
    private Hook hook;

    @Autowired
    private EtsyHomePage etsyHomePage;

    private void switchTab(String parentTab){
        Set<String> allTabs = hook.getDriver().getWindowHandles();
        for (String tab: allTabs) {
            if(!tab.equals(parentTab)){
                hook.getDriver().switchTo().window(tab);
            }
        }
    }

    @Given("The title of the page is {string}")
    public void the_title_of_the_page_is(String expectedTitle) {
        String actualTitle = hook.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("I search for {string}")
    public void i_search_for(String searchItem) {
        etsyHomePage.searchBar.sendKeys(searchItem + Keys.ENTER);
    }

    @Then("I verify the search result contains {string}")
    public void i_verify_the_search_result_contains(String expectedSearchResult) throws InterruptedException {
        Thread.sleep(2000);
        String actualSearchResult = etsyHomePage.searchResult.getText();
        Assert.assertTrue(actualSearchResult + "vs"+ expectedSearchResult,
                actualSearchResult.contains(expectedSearchResult));
    }

    @Then("I choose Free Shipping")
    public void i_choose_Free_Shipping() throws InterruptedException {
        Thread.sleep(3000);
        etsyHomePage.freeShipping.click();
        //etsyHomePage.freeShippingName.click();
        Thread.sleep(3000);
    }

    @Then("I verify the default price is Any Price")
    public void i_verify_the_default_price_is_Any_Price() {
        String anyPrice = etsyHomePage.anyPrice.getAttribute("checked");
        Assert.assertEquals("true", anyPrice);
//        Assert.assertTrue(Boolean.valueOf(anyPrice));
//        String under25 = etsyHomePage.under25.getAttribute("checked");
//        System.out.println("Value of Checked in any price: " + anyPrice);
//        System.out.println("Value of Checked in under25: " + under25);
    }

    @Then("I verify default selected country is {string}")
    public void i_verify_default_selected_country_is(String expectedSelectedCountry) throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(etsyHomePage.shipTo);
        String selectedCountry = select.getFirstSelectedOption().getText().trim();
        Assert.assertEquals(expectedSelectedCountry, selectedCountry);
    }

    @Given("I select item number {int} from the search result")
    public void i_select_item_number_from_the_search_result(int itemNumber) throws InterruptedException {
       etsyHomePage.searchResults.get(itemNumber-1).click();
        Thread.sleep(2000);
    }

    @Given("I select random item from the search result")
    public void i_select_random_item_from_the_search_result() throws InterruptedException {
        //Getting all web element as a list
        List<WebElement> searchResults = etsyHomePage.searchResults;
        //Generates random number between 0 and argument -1
        int num = Utilities.generateRandomNum(searchResults.size());
        String currentTab = hook.getDriver().getWindowHandle();
        searchResults.get(num).click();
        Thread.sleep(2000);
        //Switching tabs
        //switchTab(currentTab);
        Thread.sleep(1000);
        etsyHomePage.addToCart.click();
        Thread.sleep(6000);
    }





}
