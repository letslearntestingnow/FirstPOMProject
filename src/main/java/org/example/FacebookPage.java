package org.example;

import org.testng.Assert;

public class FacebookPage extends Utils
{
    public void verifyUserIsOnFacebookPage(String strChildWindowHandle)
    {
        //Switch Driver's focus to Child window (new tab)
        driver.switchTo().window(strChildWindowHandle);

        // Ensure driver has navigated to the correct page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce",
                "This is not the Facebook page.");
    }

    public void closeFacebookTab(String strParentWindowHandle)
    {
       // Close the tab
       driver.close();

        // and now return focus to the parent window
        driver.switchTo().window(strParentWindowHandle);
    }
}
