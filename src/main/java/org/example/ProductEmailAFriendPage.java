package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductEmailAFriendPage extends Utils
{
    private By _FriendEmailTextBox_Id = By.id("FriendEmail");
    private By _PersonalMessage_Id = By.id("PersonalMessage");
    private By _SendEmailButton_Name = By.name("send-email");
    private By _SuccessfulMessage_ClassName = By.className("result");

    private String strFriendsEmail = "xyz@mail.com";
    private String strPersonalMessage = "This is good. Recommended.";
    private String strMessageSentSuccessfully = "Your message has been sent.";

    public void typeMessageForm()
    {
        typeText(_FriendEmailTextBox_Id, strFriendsEmail);
        typeText(_PersonalMessage_Id, strPersonalMessage);
    }

    public void clickSendEmailButton()
    {
        clickOnElement(_SendEmailButton_Name);
    }

    public void verifyMessageWasSentSuccessfully()
    {
        Assert.assertEquals(getTextFromElement(_SuccessfulMessage_ClassName), strMessageSentSuccessfully, "Personal Message failed.");
    }

}
