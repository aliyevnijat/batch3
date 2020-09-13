package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class BOFA_Page implements BasePage{

    @FindBy(how = How.CSS,using = "[id=\"footer_bofa_locations\"]\n")
    public WebElement location;

    @FindBy(how = How.CSS,using = "[id=\"aria-map-list-header\"]\n")
    public WebElement shown_Text;

    @FindBy(how = How.CSS,using = "[alt=\"Bank of America Logo\"]")
    public WebElement BOFA_Logo;

    @FindBy(how = How.CSS,using = "[id=\"footer_bofa_contactus\"]")
    public WebElement Contact_us;

    @FindBy(how = How.CSS,using = "[id=\"skip-to-h1\"]")
    public WebElement customer_servicetext;

    @FindBy(how = How.CSS,using = "[id=\"navSavings\"]")
    public WebElement Savings;

}
