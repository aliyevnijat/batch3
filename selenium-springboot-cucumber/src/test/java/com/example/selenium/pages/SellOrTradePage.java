package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class SellOrTradePage implements BasePage {

    @FindBy(how = How.CSS, using = "[data-analytics-event-label='Sell or Trade']")
    public WebElement sellOrTrade;

    @FindBy(how = How.CSS, using = "[aria-label='License Plate Number']")
    public WebElement licensePlate;

    @FindBy(how = How.NAME, using = "licensePlateState")
    private WebElement stateName;

    public void selectState(String state){
        Select select = new Select(stateName);
        select.selectByVisibleText(state);

    }

    @FindBy(how = How.CSS, using = "[class='btn-inner btn-fade']")
    public WebElement getStarted;

}
