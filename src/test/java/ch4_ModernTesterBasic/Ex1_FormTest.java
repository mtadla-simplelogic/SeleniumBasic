package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Ex1_FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        driver.findElement(By.id("inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.id("inputEmail3")).sendKeys("j.k@w.pl");
        driver.findElement(By.id("inputAge3")).sendKeys("45");

        List<WebElement> genders = driver.findElements(By.name("gridRadiosSex"));
        genders.get(0).click();

        getRandomElement(driver.findElements(By.name("gridRadiosExperience")))
                .click();

        List<WebElement> professions = driver.findElements(By.name("gridCheckboxProfession"));
        Assert.assertTrue(professions.size() > 0);

        for (WebElement profession : professions) {
            profession.click();
        }

        Select continents = new Select(driver.findElement(By.id("selectContinents")));

        // continents.selectByIndex(2);
        continents.selectByValue("europe");
        // continents.selectByVisibleText("Europe");

        Select seleniumCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        List<WebElement> allSeleniumCommandsOptions = seleniumCommands.getOptions();

        for (WebElement element : allSeleniumCommandsOptions) {
            element.click();
        }


        WebElement fileUpload = driver.findElement(By.id("chooseFile"));
        File file = new File("src/main/resources/file.txt");
        fileUpload.sendKeys(file.getAbsolutePath());

        driver.findElement(By.className("btn-primary")).click();
        String msg = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(msg, "Form send with success");
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        return elements.get(randomListIndex);
    }
}
