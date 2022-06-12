package ch8_scroll;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Ex1_ScrollingTests extends TestBase {

    @Test
    public void shouldScrollToElementUsingOldMethod() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    @Test
    public void shouldScrollToElement() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");

        WebElement element = driver.findElement(By.xpath("//p[.=' 90%']"));

        new Actions(driver).scrollToElement(element).perform();
    }

    @Test
    public void shouldScrollByPixels() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");

        new Actions(driver).scrollByAmount(0, 200).perform();
    }

    @Test
    public void shouldScrollUntilHiddenButtonAppears() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");


        for (int i = 0; i < 20; i++) {
            new Actions(driver).scrollByAmount(0, 200).perform();
            if (isDisplayed(By.cssSelector("#scroll-button"))) {
                break;
            }
        }
        driver.findElement(By.cssSelector("#scroll-button")).click();
    }

    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
