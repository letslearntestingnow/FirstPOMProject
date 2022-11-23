package org.example;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestSuite extends BaseTest
{
    // Create objects to be used for corresponding pages
    HomePage objHomePage = new HomePage();
    RegisterPage objRegisterPage = new RegisterPage();
    RegisterResultPage objRegisterResultPage = new RegisterResultPage();
    ElectronicsPage objElectronicsPage = new ElectronicsPage();
    CameraPhotoPage objCameraPhotoPage = new CameraPhotoPage();
    NewReleasePage objNewReleasePage = new NewReleasePage();
    FacebookPage objFacebookPage = new FacebookPage();
    AppleMacbookProPage objAppleMacbookProPage = new AppleMacbookProPage();
    ProductEmailAFriendPage objProductEMailAFriendPage = new ProductEmailAFriendPage();


    @Test
    public void toVerifyUserCanReferAppleMacbookToAFriend()
    {
        // Land on homepage
        // Register as a user
        objHomePage.clickOnRegisterButton();
        objRegisterPage.enterRegistrationDetails();
        // Back to homepage
        objRegisterPage.clickOnContinueButtonAfterSuccessfulRegistration();

        // Click on Apple Macbook
        objHomePage.clickOnAppleMacbookPro();

        // Click on "Email a Friend"
        objAppleMacbookProPage.clickOnEmailAFriendButton();

        // Fill the form and send email
        objProductEMailAFriendPage.typeMessageForm();
        objProductEMailAFriendPage.clickSendEmailButton();

        // Verify successful message
        objProductEMailAFriendPage.verifyMessageWasSentSuccessfully();
    }

    @Test
    public void toVerifyFacebookButtonOpensTheCorrectURL()
    {
        // Land on Homepage

        // Click on Facebook button
        objHomePage.clickOnFacebookButton();

        // Get handles for all opened windows
        Set<String> allWindowHandles = objHomePage.getAllWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Get Parent Window ID from the iterator
        String strParentWindowHandle = iterator.next();
        System.out.println("Parent window ID: " + strParentWindowHandle);

        // Get Child Window ID from the iterator
        String strChildWindowHandle = iterator.next();
        System.out.println("Child window ID: " + strChildWindowHandle);

        // verify the URL opened in new tab is correct
        objFacebookPage.verifyUserIsOnFacebookPage(strChildWindowHandle);

        // Move driver back to the parent window and close the tab
        objFacebookPage.closeFacebookTab(strParentWindowHandle);
    }
    @Test
    public void toVerifyAlertIsDisplayedAndAccepted()
    {
        // Land on homepage
        // Click on Vote button
        objHomePage.clickOnVoteButton();

        // Verify alert is displayed and accepted
        objHomePage.acceptAlertOnHomepage();
    }
    @Test
    public void toVerifyCommentOnNewReleasePage()
    {
        // Land on Homepage

        // Click on New Release details button
        objHomePage.clickOnNewReleaseButton();

        // Verify user is on New Release Page
        objNewReleasePage.verifyUserIsOnNewReleasePage();

        // Write title and Comment
        objNewReleasePage.enterTitleAndComment();

        // Click on New Comment button
        objNewReleasePage.clickOnNewCommentButton();

        // Verify if the message was successfully posted
        System.out.println(objNewReleasePage.getNewsCommentSuccessfulMessage());
        objNewReleasePage.verifySuccessfulCommentMessage();

        // Verify message is at the bottom
        objNewReleasePage.verifyCommentIsAtTheBottom();

    }

    @Test
    public void toVerifyCurrencySymbolOnHomePage()
    {
        // Land on Homepage
        waitForUrlToBe("https://demo.nopcommerce.com/", 5);

        // Get the options in the Currency drop down
        List<WebElement> listOfElements = objHomePage.getAllElementsFromCurrencyDropdown();

        // Iterate through the options in the Currency drop down
        for (WebElement listEle: listOfElements)
        {
            // For US Dollar
            if (listEle.getText().equals("US Dollar"))
            {
                // Select US Dollar from drop down
                objHomePage.selectFromCurrencyDropdownByVisibleText("US Dollar");

                // Iterate through all products on home page
                List<WebElement> Products = objHomePage.getAllProductPricesElements();
                for (WebElement listProduct : Products)
                {
                    // Verify the product has the $ symbol
                    //System.out.println(listProduct.getText().charAt(0));
                    Assert.assertEquals(listProduct.getText().charAt(0), '$', "Incorrect symbol in Product Price");
                }
                
            } else if (listEle.getText().equals("Euro"))
            {
                // else select EURO in dropdown
                objHomePage.selectFromCurrencyDropdownByVisibleText("Euro");

                // Iterate through all products on home page
                List<WebElement> Products = objHomePage.getAllProductPricesElements();
                for (WebElement listProduct : Products)
                {
                    // Verify the product has the € symbol
                    //System.out.println(listProduct.getText().charAt(0));
                    Assert.assertEquals(listProduct.getText().charAt(0), '€', "Incorrect symbol in Product Price");
                }
            }
        }

    }
    @Test
    public void toVerifyEachProductHasName()
    {
        // Land on Homepage

        // Navigate to Electronics page
        objHomePage.clickOnElectronicsButton();
        // Navigate to Camera & Photo page
        objElectronicsPage.clickOnCameraButton();
        // Print names of all the products
        objCameraPhotoPage.printProductNames();

    }
    @Test
    public void toVerifyUserIsAbleToRegister()
    {
        // Click on Register button, present on the Homepage
        objHomePage.clickOnRegisterButton();

        // Confirm the driver navigated to the correct page
        objRegisterPage.verifyUserIsOnRegisterPage();

        // Input the Registration details in the web form
        objRegisterPage.enterRegistrationDetails();

        // Verify if the user has been registered successfully
        objRegisterResultPage.verifyUserHasBeenRegisteredSuccessfully();
    }
}
