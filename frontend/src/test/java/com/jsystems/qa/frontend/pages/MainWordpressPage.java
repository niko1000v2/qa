package com.jsystems.qa.frontend.pages;

import com.jsystems.qa.frontend.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordpressPage extends BasePage {

    public MainWordpressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in")
    public WebElement loginLink;

    private void login(){


    MainWordpressPage wordpressPage = new MainWordpressPage(driver);

    wordpressPage.waitForVisibilityOfElement(wordpressPage.loginLink, 30);
    wordpressPage.loginLink.click();


        LoginPage loginPage = new LoginPage(driver);

        waitForVisibilityOfElement(loginPage.loginBox, 30);

        //loginBox.clear();
        loginPage.loginBox.sendKeys(Configuration.LOGIN);
        loginPage.loginBox.sendKeys(Keys.RETURN);

        loginPage.waitForVisibilityOfElement(loginPage.passwordBox, 30);
        loginPage.passwordBox.clear();
        loginPage.passwordBox.sendKeys(Configuration.PASSWORD);
        loginPage.passwordBox.sendKeys(Keys.RETURN);

}}
