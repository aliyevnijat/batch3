package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class EtsyexplorePage implements BasePage{
   @FindBy(how = How.CSS,using = "[class=\"horizontal-center appears-ready\"]")
    public WebElement shownText;
    @FindBy(how = How.CSS,using = "[data-id=\"search-query\"]")
    public WebElement search;
    @FindBy(how = How.CSS,using = "[class=\"etsy-icon wt-nudge-b-1\"]\n")
    public WebElement searchclick;
//

//    @FindBy(how = How.CSS,using = "[name=\"free_shipping\"]")
//    public WebElement Free_Sipping_Filter;
    @FindBy(how = How.CSS,using = "[class=\"display-inline strong wt-text-caption\"]")
    public WebElement searchitemtext;
    @FindBy(how = How.CSS,using = "[aria-label=\"Any price\"]")
    public WebElement AnyPrice;
    @FindBy(how = How.CSS,using = "[class=\"wt-pl-xs-2 wt-mb-xs-1\"]")
    public WebElement FreeShipping;
    @FindBy(how = How.CSS,using = "[id=\"ship_to_select\"]")
    public WebElement ShiptoText;
    @FindBy(how = How.CSS,using = "[id=\"ship_to_select\"]")
    public WebElement ShiptoText1;
    @FindBy(how = How.CSS,using = "[class=\"height-placeholder\"]")
    public WebElement Firstitem;
    @FindBy(how = How.CSS,using = "[class=\"wt-position-relative wt-text-caption\"]")
    public WebElement Showntext_below;
//    @FindBy(how = How.CSS,using = "[id=\"inventory-variation-select-0\"]")
//    public WebElement Device;
//    @FindBy(how = How.CSS,using = "[id=\"inventory-variation-select-1\"]")
//    public WebElement Customize;
    @FindBy(how = How.CSS,using = "[class=\"wt-btn wt-btn--filled wt-width-full\"]")
    public WebElement AddToCart;
    @FindBy(how = How.CSS,using = "[class=\"etsy-icon\"]")
    public WebElement CartLogo;
    @FindBy(how = How.CSS,using = "[id=\"page-title\"]")
    public WebElement ShownText;
}
