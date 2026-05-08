package Pages;

import base.BasePage;
import configuration.ConfigReader;
import org.openqa.selenium.*;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By maleGender = By.xpath("//label[text()='Male']");
    By mobile = By.id("userNumber");
    By sports = By.xpath("//label[text()='Sports']");
    By address = By.id("currentAddress");
    By submit = By.id("submit");
    By successModal = By.id("example-modal-sizes-title-lg");

    public void openPracticeForm() {
        driver.get(ConfigReader.get("base.url") + "/automation-practice-form");
    }

    public void fillValidForm() {
        type(firstName, "Vijay");
        type(lastName, "Kumar");
        type(email, "vijay@test.com");
        click(maleGender);
        type(mobile, "9876543210");
        click(sports);
        type(address, "Chennai");
    }

    public void submitForm() {
        click(submit);
    }

    public boolean isSubmissionSuccessful() {
        return getText(successModal).equals("Thanks for submitting the form");
    }

    public boolean isFirstNameErrorDisplayed() {
        WebElement element = driver.findElement(firstName);
        return element.getAttribute("class").contains("is-invalid");
    }
}