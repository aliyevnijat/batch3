package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtsyHomePage implements BasePage {
    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBar;

    @FindBy(how = How.CSS, using = "[class='display-inline strong wt-text-caption']")
    public WebElement searchResult;

    @FindBy(how = How.CSS, using = "[href*='free_shipping']")
    public WebElement freeShipping;

    @FindBy(name = "free_shipping")
    public WebElement freeShippingName;

    @FindBy(how = How.CSS, using = "[aria-label='Any price']")
    public WebElement anyPrice;

    @FindBy(how = How.CSS, using = "[aria-label='Under $25']")
    public WebElement under25;

    @FindBy(id = "ship_to_select")
    public WebElement shipTo;

    @FindBy(how = How.CSS, using = "[class='placeholder placeholder-landscape  ']")
    public List<WebElement> searchResults;

    @FindBy(how = How.CSS, using = "[class='wt-btn wt-btn--filled wt-width-full']")
    public WebElement addToCart;





}
