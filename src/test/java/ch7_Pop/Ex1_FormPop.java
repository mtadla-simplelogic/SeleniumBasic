package ch7_Pop;

import ch3_TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class Ex1_FormPop extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {

        driver.get("https://seleniumui.moderntester.pl/form.php");

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("j.k23@wp.pl");
        formPage.setAge("23");
        formPage.selectRandomGender();
        formPage.selectContinent("europe");

        formPage.selectSeleniumCommand("browser-commands");
        formPage.selectSeleniumCommand("switch-commands");

        File file = new File("src/main/resources/file.txt");
        formPage.uploadFile(file);


        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");
    }
}
