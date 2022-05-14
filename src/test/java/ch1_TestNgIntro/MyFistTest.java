package ch1_TestNgIntro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFistTest {

    @Test
    public void shouldPrintHello() {
        System.out.println("This is test! -> Hello!");
        int i = 1;
        Assert.assertEquals(i, 2);
        System.out.println("To jest koniec testu pierwszego");
    }

    @Test
    public void shouldPrintHelloWorld() {
        System.out.println("This is test! -> Hello World!");
        int i = 2;
        Assert.assertEquals(i, 2);
        System.out.println("To jest koniec testu drugiego");

    }

    @BeforeMethod
    public void beforeEachTestMethod() {
        System.out.println(">> I was executed BEFORE! each test");
    }

    @AfterMethod
    public void afterEachTestMethod() {
        System.out.println(">> I was executed AFTER! each test");
    }


}
