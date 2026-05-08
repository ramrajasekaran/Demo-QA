package Pages;

import base.BasePage;
import configuration.ConfigReader;
import org.openqa.selenium.*;

public class WidgetsPage extends BasePage {

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    By dateInput = By.id("datePickerMonthYearInput");
    By slider = By.xpath("//input[@type='range']");
    By sliderValue = By.id("sliderValue");
    By sectionOneHeading = By.id("section1Heading");
    By sectionOneContent = By.id("section1Content");
    By sectionTwoHeading = By.id("section2Heading");

    public void openDatePickerPage() {
        driver.get(ConfigReader.get("base.url") + "/date-picker");
    }

    public void selectDate(String date) {
        WebElement element = waitForElement(dateInput);
        element.clear();
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);
    }

    public String getSelectedDate() {
        return driver.findElement(dateInput).getAttribute("value");
    }

    public void openSliderPage() {
        driver.get(ConfigReader.get("base.url") + "/slider");
    }

    public void moveSlider() {
        WebElement element = driver.findElement(slider);
        element.sendKeys(Keys.ARROW_RIGHT);
        element.sendKeys(Keys.ARROW_RIGHT);
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getAttribute("value");
    }

    public void openAccordionPage() {
        driver.get(ConfigReader.get("base.url") + "/accordian");
    }

    public void clickSectionOne() {
        click(sectionOneHeading);
    }

    public void clickSectionTwo() {
        click(sectionTwoHeading);
    }

    public boolean isSectionOneDisplayed() {
        return driver.findElement(sectionOneContent).isDisplayed();
    }
}