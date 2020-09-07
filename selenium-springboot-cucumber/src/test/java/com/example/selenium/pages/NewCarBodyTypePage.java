package com.example.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewCarBodyTypePage implements BasePage{
    @FindBy(how = How.CSS, using = "[class='btn btn-primary btn-md btn-block']")
    public WebElement shopNewSearch;
    @FindBy(how = How.CSS, using = "[data-qa=\"model-search-option-body\"]")
    public WebElement bodytype;
    @FindBy(how = How.CSS, using = "[class=\"text-center col-6 col-md-4\"]")
    private List<WebElement> carbodytypes;
    public void assertionprocess(int expected){
        Assert.assertEquals(expected,carbodytypes.size());
    }
}
