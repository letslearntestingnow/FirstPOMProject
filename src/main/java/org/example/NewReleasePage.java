package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class NewReleasePage extends Utils
{

    private By _NewReleaseTitle_Id = By.id("AddNewComment_CommentTitle");
    private By _NewReleaseText_Id = By.id("AddNewComment_CommentText");
    private By _NewCommentButton_Name = By.name("add-comment");
    private By _NewCommentSuccessfulMessage_ClassName = By.className("result");
    private By _NewCommentPostedList_X = By.xpath("//strong [@class=\"comment-text\"]");

    private String strTitle = "My Title Text";
    private String strComment = "Line 1 - abcd efgh ijk lmno";

    public void verifyUserIsOnNewReleasePage()
    {
        // Ensure driver has navigated to the correct page
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/nopcommerce-new-release",
                "This is not the New Release page.");
    }

    public void enterTitleAndComment()
    {
        // Enter Title
        typeText(_NewReleaseTitle_Id, strTitle);

        // Enter Comment
        typeText(_NewReleaseText_Id, strComment);
    }

    public void clickOnNewCommentButton()
    {
        clickOnElement(_NewCommentButton_Name);
    }

    public String getNewsCommentSuccessfulMessage()
    {
        return getTextFromElement(_NewCommentSuccessfulMessage_ClassName);
    }

    public void verifySuccessfulCommentMessage()
    {
        // Verify if new comment was posted successfully
        Assert.assertEquals(getTextFromElement(_NewCommentSuccessfulMessage_ClassName), "News comment is successfully added.",
                "New comment was not posted successfully.");
    }

    public void verifyCommentIsAtTheBottom()
    {
        List<WebElement> listOfComments = getAllElementsMatchingThisLocator(_NewCommentPostedList_X);

        for (int i = 0; i < listOfComments.size(); i++)
        {
            if (i == (listOfComments.size()-1))
            {
                // Verify the comment was posted the bottom of the page
                Assert.assertEquals(listOfComments.get(i).getText(), strTitle,
                        "Your comment was not found at the bottom of the page.");
            }
        }

    }
}
