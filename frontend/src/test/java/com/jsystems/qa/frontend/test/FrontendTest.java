package com.jsystems.qa.frontend.test;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.pages.LoginPage;
import com.jsystems.qa.frontend.pages.MainWordpressPage;
import com.jsystems.qa.frontend.pages.UserPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFrontEnd {
    MainWordpressPage wordporessPage;
    LoginPage loginPage;
    UserPage userPage;

    @Test
    public void firstFrontTest() {
        wordporessPage = new MainWordpressPage(driver);

        assertTrue(wordporessPage.loginLink.isDisplayed());
        assertEquals(wordporessPage.loginLink.getText(), "Log In");
        wordporessPage.loginLink.click();
    }

    @Test
    public void loginTest() {
        login();

        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.avatarBox, 30);
        assertTrue(userPage.avatarBox.isDisplayed());

//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        driver.switchTo().alert();

    }

    @DisplayName("Login action test")
    @Test
    public void loginActionTest() {

        wordporessPage = new MainWordpressPage(driver);
        wordporessPage.waitForVisibilityOfElement(wordporessPage.loginLink, 30);
        wordporessPage.loginLink.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.loginBox, 30);

        Actions action = new Actions(driver);
        action
                .moveToElement(loginPage.loginBox)
                .sendKeys(Configuration.LOGIN)
                .sendKeys(Keys.chord(Keys.ENTER))
                .build()
                .perform();

        loginPage.waitForVisibilityOfElement(loginPage.passwordBox, 30);

    }

    private void login() {
        wordporessPage = new MainWordpressPage(driver);
        wordporessPage.waitForVisibilityOfElement(wordporessPage.loginLink, 30);
        wordporessPage.loginLink.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.loginBox, 30);
        loginPage.loginBox.clear();
        loginPage.loginBox.sendKeys(Configuration.LOGIN);
        loginPage.loginBox.sendKeys(Keys.RETURN);
      //  loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.passwordBox, 30);
        loginPage.passwordBox.clear();
        loginPage.passwordBox.sendKeys(Configuration.PASSWORD);
        loginPage.passwordBox.sendKeys(Keys.RETURN);
    }


}