package org.example;

import org.openqa.selenium.By;

public class AppleMacbookProPage extends Utils
{
    private By _EmailAFriendButton_X = By.xpath("//button[@class='button-2 email-a-friend-button']");


    public void clickOnEmailAFriendButton()
    {
        clickOnElement(_EmailAFriendButton_X);
    }
}
