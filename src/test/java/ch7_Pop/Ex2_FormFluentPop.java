package ch7_Pop;

import ch3_TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class Ex2_FormFluentPop extends TestBase {
    FormPage formPage;
    File file = new File("src/main/resources/file.txt");

    @BeforeMethod
    public void testSetup(){
        formPage = new FormPage(driver);
        driver.get("https://seleniumui.moderntester.pl/form.php");
    }

    @Test
    public void shouldFillFormWithSuccess() {
        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("j.k23@wp.pl")
                .setAge("23")
                .selectRandomGender()
                .selectRandomkExperiences()
                .selectRandomProfession()
                .selectContinent("europe")
                .selectSeleniumCommand("browser-commands")
                .selectSeleniumCommand("switch-commands")
                .uploadFile(file)
                .submitForm();

        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");
    }
}
