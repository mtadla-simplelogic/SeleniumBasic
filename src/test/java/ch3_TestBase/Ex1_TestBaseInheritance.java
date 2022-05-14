package ch3_TestBase;

import org.testng.annotations.Test;

public class Ex1_TestBaseInheritance extends TestBase {

    @Test
    public void shouldOpenWebsite() {
        driver.get("https://seleniumui.moderntester.pl/");
    }
}
