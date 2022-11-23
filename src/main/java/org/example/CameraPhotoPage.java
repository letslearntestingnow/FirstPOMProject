package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CameraPhotoPage extends Utils
{
    public void printProductNames()
    {
        List<WebElement> listCameras = driver.findElements(By.xpath("//h2 [@class = 'product-title']"));
        for(WebElement ele: listCameras)
        {
            System.out.println(ele.getText());
        }

    }
}
