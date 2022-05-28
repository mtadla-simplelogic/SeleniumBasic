package ch5_FirstHomework;

import ch3_TestBase.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex2_RegisterNewUser extends TestBase {

    @Test
    public void shouldRegisterNewUser(){
        driver.get("http://146.59.32.4/index.php");

        driver.findElement(By.cssSelector(".user-info a")).click();

        driver.findElement(By.cssSelector(".no-account")).click();

        driver.findElement(By.name("firstname")).sendKeys("Jan");
        driver.findElement(By.name("lastname")).sendKeys("Kowalski");
        driver.findElement(By.cssSelector("#customer-form [name='email']")).sendKeys("jk@wp.pl");
        driver.findElement(By.name("password")).sendKeys("asdiujasiduhasd");

        driver.findElements(By.name("id_gender")).get(0).click();
        driver.findElement(By.name("customer_privacy")).click();
        driver.findElement(By.name("psgdpr")).click();

        driver.findElement(By.cssSelector(".form-footer button")).click();

        String userName = driver.findElement(By.cssSelector(".account")).getText();
        Assert.assertEquals(userName, "Jan Kowalski");
    }

    private String getRandomEmail(){
        return RandomStringUtils.randomAlphabetic(10) + "@wp.pl";
    }
}
