package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstName;

    @FindBy(css = "#inputLastName3")
    private WebElement lastName;

    @FindBy(css = "#inputEmail3")
    private WebElement email;

    @FindBy(css = "#inputAge3")
    private WebElement age;

    @FindBy(css = "#validator-message")
    private WebElement validationMsg;

    @FindBy(css = "#selectContinents")
    private WebElement selectContinents;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement selectSeleniumCommands;
    @FindBy(css = "#chooseFile")
    private WebElement fileInput;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> genders;

    public void selectAllSeleniumCommands() {
        List<WebElement> allSeleniumOptions = new Select(selectSeleniumCommands).getOptions();

        for (WebElement option : allSeleniumOptions) {
            option.click();
        }
    }

    public void selectAllSeleniumCommandsV2() {
        int quantityOfOptions = new Select(selectSeleniumCommands).getOptions().size();

        for (int i = 0; i < quantityOfOptions; i++) {
            selectSeleniumCommand(i);
        }
    }

    public void selectSeleniumCommand(String seleniumCommand) {
        new Select(selectSeleniumCommands).selectByValue(seleniumCommand);
    }

    public void selectSeleniumCommand(int index) {
        new Select(selectSeleniumCommands).selectByIndex(index);
    }

    public void uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void selectContinent(String continent) {
        new Select(selectContinents).selectByValue(continent);
    }

    public void selectRandomGender() {
        getRandomElement(genders).click();
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setAge(String age) {
        this.age.sendKeys(age);
    }

    public String getValidationMsg() {
        return validationMsg.getText();
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        return elements.get(randomListIndex);
    }
}
