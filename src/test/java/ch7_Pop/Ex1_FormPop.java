package ch7_Pop;

import ch3_TestBase.TestBase;
import org.testng.annotations.Test;
import pages.FormPage;

public class Ex1_FormPop extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        FormPage formPage = new FormPage(driver);
        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("j.k23@wp.pl");
        formPage.setAge("23");
    }
}
