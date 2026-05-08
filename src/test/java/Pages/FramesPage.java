package Pages;

import base.BasePage;
import configuration.ConfigReader;
import org.openqa.selenium.*;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    By frameText = By.id("sampleHeading");
    By body = By.tagName("body");

    public void openFramesPage() {
        driver.get(ConfigReader.get("base.url") + "/frames");
    }

    public void switchToFrameOne() {
        driver.switchTo().frame("frame1");
    }

    public String getFrameText() {
        return getText(frameText);
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }

    public void openNestedFramesPage() {
        driver.get(ConfigReader.get("base.url") + "/nestedframes");
    }

    public String getNestedFrameText() {
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        return getText(body);
    }
}