package ch6_Waits;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex3_LoadingBar extends TestBase {
    WebDriverWait wait;

    @BeforeMethod
    public void testSetup() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void shouldWaitForLoadingBarV1() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");

        //textToBe -> text musi być dokładny 1 do 1
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));
    }

    @Test
    public void shouldWaitForLoadingBarV2() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        // textToBePresentInElementLocated -> tekst spodziewany musi się zawierać w tekście wyświetlonym
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".progress-label"), "Complete"));
    }

    @Test
    public void shouldWaitForLoadingBarV3() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        // textToBePresentInElementLocated -> tekst spodziewany musi się zawierać w tekście wyświetlonym
        WebElement progressBar = driver.findElement(By.cssSelector(".progress-label"));
        wait.until(ExpectedConditions.textToBePresentInElement(progressBar, "Complete"));
    }

    @Test
    public void shouldWaitForLoadingBarV4() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");

        // attributeContains -> tekst w atrybucie musi zawierać w tekst spodziewany
        WebElement progressBar = driver.findElement(By.cssSelector(".ui-progressbar-value"));
        wait.until(ExpectedConditions.attributeContains(progressBar, "class", "ui-progressbar-complete"));
    }

    @Test
    public void shouldWaitForLoadingBarV5() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");

        wait.until(ExpectedConditions.attributeContains(By.cssSelector(".ui-progressbar-value"), "class", "ui-progressbar-complete"));
    }

    @Test
    public void shouldWaitForLoadingBarV6() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");

        WebElement progressBar = driver.findElement(By.cssSelector(".ui-progressbar-value"));

        // attributeToBe -> text atrybuty musi być dokładny 1 do 1
        wait.until(ExpectedConditions.attributeToBe(progressBar, "class",
                "ui-progressbar-value ui-corner-left ui-widget-header ui-progressbar-complete ui-corner-right"));
    }

    @Test
    public void shouldWaitForLoadingBarV7() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");

        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".ui-progressbar-value"), "class",
                "ui-progressbar-value ui-corner-left ui-widget-header ui-progressbar-complete ui-corner-right"));
    }
}

