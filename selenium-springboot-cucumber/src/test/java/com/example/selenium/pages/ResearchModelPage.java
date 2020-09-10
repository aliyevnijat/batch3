package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class ResearchModelPage implements BasePage{

    @FindBy(how = How.CSS, using = "[data-test='globalNavResearch']")
    public WebElement research;

    @FindBy(how = How.CSS, using = "[aria-label='Select Make']")
    public WebElement selectMake;

    @FindBy(how = How.CSS, using = "[aria-label='Select Model']")
    public WebElement selectModel;

    @FindBy(how = How.CSS, using = "[data-test='modelOverviewCtaActionButton'] [class='btn-inner']")
    public WebElement GO;

    @FindBy(how = How.CSS, using = "[data-test='vehicleHeaderModelOverview']")
    public WebElement header;

}
