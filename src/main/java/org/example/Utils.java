package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils extends BasePage
{
    // Click on Element
    public static void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    // Hover on Element
    public static boolean hoverOnElement(By by)
    {
        return driver.findElement(by).isSelected();
    }

    // Type the provided text in the element
    public static void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    // Get text from element
    public static void getTextFromElement(By by)
    {
        driver.findElement(by).getText();
    }

    // Get Time stamp from System
    public static String getTimeStamp()
    {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmssSSS"));
    }

    // Explicit Wait - for the element to be clickable
    public static void waitForElementToBeClickable(By by, int iSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // Explicit Wait - for the element to be visible
    public static void waitForElementToBeVisible(By by, int iSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Explicit Wait - for the browser to navigate to expected URL
    public static void waitForUrlToBe(String strURL, int iSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iSeconds));
        wait.until(ExpectedConditions.urlToBe(strURL));
    }

    // Select from dropdown using visible text
    public static void selectFromDropdownByVisibleText(By by, String strElement, String strText)
    {
        Select objSelect = new Select(driver.findElement(by.name(strElement)));
        objSelect.selectByVisibleText(strText);
    }

    // Select from dropdown using value
    public static void selectFromDropdownByValue(By by, String strElement, String strValue)
    {
        Select objSelect = new Select(driver.findElement(by.name(strElement)));
        objSelect.selectByValue(strValue);
    }

    // Select from dropdown using index
    public static void selectFromDropdownByIndex(By by, String strElement, int iIndex)
    {
        Select objSelect = new Select(driver.findElement(by.name(strElement)));
        objSelect.selectByIndex(iIndex);
    }

}
