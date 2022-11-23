package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CameraPhotoPage extends Utils
{
    private By _ListOfProductNames_ClassName = By.className("product-title");

    private By _ListOfProductsComplete_ClassName = By.className("details");

    public void printProductNames()
    {
        List<WebElement> listCameras = getAllElementsMatchingThisLocator(_ListOfProductNames_ClassName);
        for(WebElement ele: listCameras)
        {
            System.out.println(ele.getText());
        }
    }

    public void checkProductsForAddToCartButton()
    {
        List<WebElement> listCameras = getAllElementsMatchingThisLocator(_ListOfProductsComplete_ClassName);

        for(WebElement ele: listCameras)
        {
        if (!(ele.getText().contains("ADD TO CART")))
            {
                //System.out.println(ele.getText());
                System.out.println(ele.findElement(By.className("product-title")).getText());
            }

        }
    }
}
