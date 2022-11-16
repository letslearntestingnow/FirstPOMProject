package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RegisterPage extends Utils
{
    // Assign locators to private variables
    private String _RegisterButtonClassName = "ico-register";
    private String _GenderMaleId = "gender-male";
    private String _FirstNameId = "FirstName";
    private String _LastNameId = "LastName";
    private String _DOBDayId = "DateOfBirthDay";
    private String _DOBMonthId = "DateOfBirthMonth";
    private String _DOBYearId = "DateOfBirthYear";
    private String _EmailIdId = "Email";
    private String _CompanyId = "Company";
    private String _PasswordID = "Password";
    private String _ConfirmPasswordID = "ConfirmPassword";
    private String _RegisterButtonId = "register-button";


    // Test Data
    private String strDataFirstName = "abcd";
    private String strDataLastName = "xyz";
    private String strDataDOBDay = "10";
    private String strDataDOBMonth = "1";
    private String strDataDOBYear = "2000";
    private String strDataEmailSuffix = "@mail.com";
    private String strDataCompanyName = "abc ltd";
    private String strDataPassword = "abc123";
    private String strDataConfirmPassword = "abc123";



    public void clickOnRegisterButton()
    {
        // Click on Register button
        driver.findElement(By.className(_RegisterButtonClassName)).click();
    }

    public void verifyUserIsOnRegisterPage()
    {
        // Ensure driver has navigated to the correct page
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/register?returnUrl=%2F",
                "This is not the Registration page.");
    }

    public void enterRegistrationDetails()
    {
        // Click the Male gender button
        driver.findElement(By.id(_GenderMaleId)).click();

        // Type the first name
        driver.findElement(By.id(_FirstNameId)).sendKeys(strDataFirstName);

        // Type the last name
        driver.findElement(By.id(_LastNameId)).sendKeys(strDataLastName);

        // Select day for DOB
        Select objSelect = new Select(driver.findElement(By.name(_DOBDayId)));
        objSelect.selectByValue(strDataDOBDay);

        // Select Month for DOB
        objSelect = new Select(driver.findElement(By.name(_DOBMonthId)));
        objSelect.selectByValue(strDataDOBMonth);

        // select Year for DOB
        objSelect = new Select(driver.findElement(By.name(_DOBYearId)));
        objSelect.selectByValue(strDataDOBYear);

        // Type the email
        String strTempEmail = strDataFirstName + LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmssSSS")) + strDataEmailSuffix;
        System.out.println(strTempEmail);
        driver.findElement(By.id(_EmailIdId)).sendKeys(strTempEmail);

        // Type the company name
        driver.findElement(By.id(_CompanyId)).sendKeys(strDataCompanyName);

        // Type Password
        driver.findElement(By.id(_PasswordID)).sendKeys(strDataPassword);

        // Type in confirm password
        driver.findElement(By.id(_ConfirmPasswordID)).sendKeys(strDataConfirmPassword);

        // Click on Register button
        driver.findElement(By.id(_RegisterButtonId)).click();
    }

}
