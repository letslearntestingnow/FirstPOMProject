package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class HomePage extends Utils
{
    // Assign locators to private variables
    private By _RegisterButton_ClassName = By.className("ico-register");
    private By _ElectronicsButton_LinkText = By.linkText("Electronics");
    private By _CurrencySymbol_X = By.xpath("//select [@id='customerCurrency']");
    private By _ProductPriceText_X = By.xpath("//span [@class = 'price actual-price']");
    private By _NewReleaseButton_X = By.xpath("//div [@class='buttons'] //a [@href=\"/nopcommerce-new-release\"]");
    private By _VoteButton_Id = By.id("vote-poll-1");
    private By _FacebookButton_LinkText = By.linkText("Facebook");

    private By _AppleMacbookProLink_LinkText = By.linkText("Apple MacBook Pro 13-inch");


   public List<WebElement> getAllElementsFromCurrencyDropdown()
   {
       return getAllElementsFromDropdown(_CurrencySymbol_X);
   }

   public void selectFromCurrencyDropdownByVisibleText(String string)
   {
       selectFromDropdownByVisibleText(_CurrencySymbol_X, string);
   }

   public List<WebElement> getAllProductPricesElements()
   {
       return getAllElementsMatchingThisLocator(_ProductPriceText_X);
   }

    public String getTextFromCurrencyDropDown()
    {
        //selectFromDropdownByValue(_CurrencySymbol_Id,);
        return getTextFromElement(_CurrencySymbol_X);
    }

    public void clickOnRegisterButton()
    {
        // Click on Register button
        clickOnElement(_RegisterButton_ClassName);
    }

    public void clickOnElectronicsButton()
    {
        // Click on Electronics category button
        clickOnElement(_ElectronicsButton_LinkText);
    }

    public void clickOnNewReleaseButton()
    {
        clickOnElement(_NewReleaseButton_X);
    }

    public void clickOnVoteButton()
    {
        clickOnElement(_VoteButton_Id);
    }
    public void acceptAlertOnHomepage()
    {
        Assert.assertEquals(getTextFromAlert(), "Please select an answer", "Alert text mismatch.");
        acceptAlert();
    }

    public void clickOnFacebookButton()
    {
        clickOnElement(_FacebookButton_LinkText);
    }

    public String getCurrentWindowHandle()
    {
        return getWindowHandle();
    }
    public Set<String> getAllWindowHandles()
    {
        return getWindowHandles();
    }

    public void clickOnAppleMacbookPro()
    {
        clickOnElement(_AppleMacbookProLink_LinkText);
    }

}
