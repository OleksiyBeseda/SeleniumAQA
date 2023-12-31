package ui.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.time.Duration.ofSeconds;
import static ui.selenium.config.WebDriverInit.getDriver;

public class BaseMethod {

    protected WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), ofSeconds(10));
    }

    protected Actions getAction() {
        return new Actions(getDriver());
    }

    protected void doubleClick(By locator) {
        WebElement doubleElement = getWait().until(driver -> driver.findElement(locator));
        getAction().doubleClick(doubleElement).build().perform();
    }
    protected void contextClick(By locator) {
        WebElement contextClick = getWait().until(driver -> driver.findElement(locator));
        getAction().contextClick(contextClick).build().perform();
    }
    protected void dragAndDrop(By drag, By drop) {
        WebElement dragElement = getWait().until(driver -> driver.findElement(drag));
        WebElement dropElement = getWait().until(driver -> driver.findElement(drop));
        getAction().dragAndDrop(dragElement, dropElement).build().perform();
    }
    protected void send(By locator, String text) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

    protected void clickEnter(By locator) {
        getWait().until(d ->d.findElement(locator)).sendKeys(Keys.ENTER);
    }
    protected String getTextFromElement(By locator) {
         return getWait().until(d ->d.findElement(locator)).getText();
    }


    protected WebDriverWait getWait(int time) {
        return new WebDriverWait(getDriver(), ofSeconds(10));
    }
    protected void click(By locator, int time) {
        getWait(time).until(d ->d.findElement(locator)).click();
    }
//    protected void send(By locator, String text, int time) {
//        getWait(time).until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
//    }

//    protected void clickEnter(By locator, int time) {
//        getWait(time).until(d ->d.findElement(locator)).sendKeys(Keys.ENTER);
//    }
//    protected String getTextFromElement(By locator, int time) {
//        return getWait(time).until(d ->d.findElement(locator)).getText();
//    }





}
