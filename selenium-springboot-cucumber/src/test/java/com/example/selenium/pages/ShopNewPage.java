package com.example.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Component
public class ShopNewPage implements BasePage {

    @FindBy(how = How.XPATH, using = "//div [@class='col-sm-12 col-md-6']")
    public WebElement shopNewSearch;

    @FindBy(how = How.XPATH, using = "//div[@class='d-inline-block align-self-center align-middle _yak6vp']")
    public List<WebElement> carMakes;

    @FindBy(how = How.XPATH, using = "//a[@data-qa='model-select-item']")
    public List<WebElement> carModels;


    public List<String> modelNamesString(){
        List <String> modelsList = new ArrayList<String>();
        for (WebElement el:carModels) {
            modelsList.add(el.getText());
        }
        return modelsList;

    }

    @FindBy(how = How.CSS, using = "[data-test='modelSearchOptionBody']")
    public WebElement bodyType;

    @FindBy(how = How.CSS, using = "[data-test='modelSearchBodyType']")
    public List<WebElement> bodyTypes;

    public void chooseBodyType(String text){
        for (int i = 0; i <bodyTypes.size() ; i++) {
            if(bodyTypes.get(i).getText().equals(text)){
                bodyTypes.get(i).click();
                break;
            }

        }
    }

    @FindBy(how = How.CSS, using = "[data-qa='model-search-brand-new']")
    public List<WebElement> numberOfCarsForTheGivenBodyType;




}