package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelComparisionPage implements BasePage{
    @FindBy(how = How.CSS, using = "[class=\"_g6b9pm\"] [href=\"/compare/\"]")
    public WebElement modelcompare;
    @FindBy(how = How.CSS, using = "[data-test=\"selectMake1\"]")
    public WebElement field1;
    @FindBy(how = How.CSS, using = "[data-test=\"selectModel1\"]")
    public WebElement field2;
    @FindBy(how = How.CSS, using = "[data-test=\"selectMake2\"]")
    public WebElement field3;
    @FindBy(how = How.CSS, using = "[data-test=\"selectModel2\"]")
    public WebElement field4;
    @FindBy(how = How.CSS, using = "[class=\"btn-inner\"]")
    public WebElement compbutton;
    @FindBy(how = How.CSS, using = "[data-test=\"modelComparisonHeader\"]")
    public WebElement shownText;

//    public void SelectDropdown(String make1,String model1 ,String make2,String model2 ){
//        Select select=new Select((WebElement) dropdown);
//        for (int i = 0; i <dropdown.size()-3 ; i++) {
//            select.selectByVisibleText(make1);
//        }
//        for (int i = 1; i <dropdown.size()-2 ; i++) {
//            select.selectByVisibleText(model1);
//        }
//        for (int i = 2; i <dropdown.size()-1 ; i++) {
//            select.selectByVisibleText(make2);
//        }
//        for (int i = dropdown.size()-1; i >=3 ; i++) {
//            select.selectByVisibleText(model2);
//        }
//    }
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){

        }
    }

}
