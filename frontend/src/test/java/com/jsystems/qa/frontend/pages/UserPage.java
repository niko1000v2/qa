package com.jsystems.qa.frontend.pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage {

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css =".masterbar__item-content>img.gravatar")
    public WebElement avatarBox;

    @FindBy(css = ".button.sidebar__me-signout-button.is-compact")
    public WebElement singOutButton;

}
