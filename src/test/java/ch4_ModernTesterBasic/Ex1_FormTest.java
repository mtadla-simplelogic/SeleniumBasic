package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex1_FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");


        driver.findElement(By.id("inputLastName3")).sendKeys("Kowalski");

        List<WebElement> genders = driver.findElements(By.name("gridRadiosSex"));
        genders.get(0).click();

        //tutaj dopisz dalsza czest testu

        String msg = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(msg, "Form send with success!");
    }
}
