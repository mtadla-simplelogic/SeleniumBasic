package ch2_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Ex1_OpenWebsite {
    WebDriver driver;

    @Test
    public void shouldOpenWebsite() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);

        driver.get("https://seleniumui.moderntester.pl/");

        Assert.assertEquals(1, 2);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
