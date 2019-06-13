package com.jsystems.qa.frontend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends BaseTest {

    final static String URL = "https://wordpress.com/";
    final static String LOGIN = "mslipek@gmail.com";
    final static String PASSWORD = "KAvat1!8h0Fx";

    public static final By LOGIN_LINK = By.partialLinkText("Log In");
    public static final By USERNAME_BOX = By.id("usernameOrEmail");
    public static final By PASSWORD_BOX = By.id("password");


    @Test
    public void firstFrontEndTest() {

        driver.get(URL);

        WebElement loginLink = driver.findElement(LOGIN_LINK);

        assertTrue(loginLink.isDisplayed());
        assertEquals(loginLink.getText(), "Log In");
        loginLink.click();

        WebElement loginBox = driver.findElement(USERNAME_BOX);
        loginBox.sendKeys(LOGIN);
        loginBox.sendKeys(Keys.RETURN);

        WebElement passwordBox = driver.findElement(PASSWORD_BOX);
        passwordBox.sendKeys(PASSWORD);
        passwordBox.sendKeys(Keys.RETURN);

    }
}
