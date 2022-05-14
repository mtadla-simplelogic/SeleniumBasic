package ch1_TestNgIntro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MySecondTest {
    public int multiply(int a, int b) {
        return 4;
    }

    public int add(int a, int b) {
        return a + b;
    }

    @Test
    public void shouldAdd() {
        int sum = add(2, 3);
        Assert.assertEquals(sum, 5);
    }


    @Test
    public void shouldMultiply() {
        Assert.assertEquals(multiply(2, 3), 6);
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
