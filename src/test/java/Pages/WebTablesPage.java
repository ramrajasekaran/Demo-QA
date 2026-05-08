package Pages;

import base.BasePage;
import configuration.ConfigReader;
import org.openqa.selenium.*;

public class WebTablesPage extends BasePage {

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    By addButton = By.id("addNewRecordButton");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By submit = By.id("submit");
    By searchBox = By.id("searchBox");
    By tableBody = By.className("rt-tbody");
    By deleteButton = By.xpath("//span[@title='Delete']");
    By nextButton = By.xpath("//button[text()='Next']");

    public void openWebTablesPage() {
        driver.get(ConfigReader.get("base.url") + "/webtables");
    }

    public void addNewRecord() {
        click(addButton);
        type(firstName, "sriram");
        type(lastName, "r");
        type(email, "ram@test.com");
        type(age, "25");
        type(salary, "50000");
        type(department, "Testing");
        click(submit);
    }

    public void searchRecord(String name) {

        WebElement search =
                waitForElement(searchBox);

        search.clear();

        search.sendKeys(name);
    }
    public boolean isRecordDisplayed(String name) {

        By tableRows =
                By.xpath("//div[@class='rt-tr-group']");

        for (WebElement row : driver.findElements(tableRows)) {

            if (row.isDisplayed()
                    && row.getText().contains(name)) {

                return true;
            }
        }

        return false;
    }

    public void deleteRecord() {
        click(deleteButton);
    }

    public boolean isNextButtonDisplayed() {
        return driver.findElement(nextButton).isDisplayed();
    }
}