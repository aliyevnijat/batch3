package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetValoueOnYourVehiclePAge implements BasePage {
     @FindBy(how = How.CSS,using = "[data-test=\"tradeButton\"]")
    public WebElement tradeButton;
    @FindBy(how = How.CSS,using = "[data-test=\"tradeLandingPageTradeFormSelectorCard-2\"]")
    public WebElement Make_Model;
    @FindBy(how = How.CSS,using = "[aria-label=\"Year\"]")
    public WebElement Yeardrop;
    @FindBy(how = How.CSS,using = "[aria-label=\"Make\"]")
    public WebElement Makedrop;
    @FindBy(how = How.CSS,using = "[aria-label=\"Model\"]")
    public WebElement Modeldrop;
    @FindBy(how = How.CSS,using = "[aria-label=\"Style\"]")
    public WebElement Styledrop;
    @FindBy(how = How.CSS,using = "[class=\"btn-inner btn-fade\"]")
    public WebElement GetStarted;

    public void SelecTGivenData(String year,String Make,String Model,String Style) throws InterruptedException {
        Select select1 =new Select(Yeardrop);
        select1.selectByVisibleText(year);
        Select select2=new Select(Makedrop);
        select2.selectByVisibleText(Make);
        Thread.sleep(1000);
        Select select3=new Select(Modeldrop);
        Thread.sleep(1000);
        select3.selectByVisibleText(Model);
        Select select4=new Select(Styledrop);
        Thread.sleep(1000);
        select4.selectByVisibleText(Style);

    }

}
