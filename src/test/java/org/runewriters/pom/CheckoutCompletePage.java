package org.runewriters.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver webDriver;
    By completeHeader = new By.ByClassName("complete-header");
    By ponyExpressImage = new By.ByClassName("pony_express");
    By backHomeButton = new By.ByClassName("btn btn_primary btn_small");

    public CheckoutCompletePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isCompleteHeaderPresent(){
        return webDriver.findElement(completeHeader).getText().equals("THANK YOU FOR YOUR ORDER");
    }

    public boolean isCompletedImagePresent(){
        return webDriver.findElement(ponyExpressImage).getAttribute("alt").equals("Pony Express");
    }

    public void clickBackHomeButton(){
        webDriver.findElement(backHomeButton).click();
    }
}
