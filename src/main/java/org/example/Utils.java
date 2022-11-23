package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

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
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    // Get similar web elements
    public static List<WebElement> getAllElementsMatchingThisLocator(By by)
    {
        return driver.findElements(by);
    }

    // Get Time stamp from System
    public static String getTimeStamp()
    {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmssSSS"));
    }

    public static String getDateStamp()
    {
        return ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MMM.yyyy"));
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
    public static void selectFromDropdownByVisibleText(By by, String strText)
    {
        Select objSelect = new Select(driver.findElement(by));
        objSelect.selectByVisibleText(strText);
    }

    // Select from dropdown using value
    public static void selectFromDropdownByValue(By by, String strValue)
    {
        Select objSelect = new Select(driver.findElement(by));
        objSelect.selectByValue(strValue);
    }

    // Select from dropdown using index
    public static void selectFromDropdownByIndex(By by, int iIndex)
    {
        Select objSelect = new Select(driver.findElement(by));
        objSelect.selectByIndex(iIndex);
    }

    public static List<WebElement> getAllElementsFromDropdown(By by)
    {
        Select objSelect = new Select(driver.findElement(by));
         return objSelect.getOptions();
    }

    public static void acceptAlert()
    {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert()
    {
        driver.switchTo().alert().dismiss();
    }

    public static String getTextFromAlert()
    {
       return driver.switchTo().alert().getText();
    }

    public static void typeTextToAlert(String string)
    {
        driver.switchTo().alert().sendKeys(string);
    }

    public static String getWindowHandle()
    {
        return driver.getWindowHandle();
    }

    public static Set<String> getWindowHandles()
    {
        return driver.getWindowHandles();
    }

    public static void captureScreenshot(String strFileName)
    {
        // Convert web driver object to take screenshots
        TakesScreenshot scrShot = (TakesScreenshot) driver;

        // Create Image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File destFile = new File("src/test/ScreenShots/"+ strFileName + "_" + getDateStamp() + "_" + getTimeStamp() + ".jpg");

        // Copy source file to destination path
        try
        {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
