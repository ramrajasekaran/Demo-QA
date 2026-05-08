package Pages;

import base.BasePage;
import configuration.ConfigReader;
import org.openqa.selenium.*;

import java.util.Set;

public class AlertsWindowsPage extends BasePage {

    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }

    By alertButton = By.id("alertButton");
    By confirmButton = By.id("confirmButton");
    By promptButton = By.id("promtButton");
    By confirmResult = By.id("confirmResult");
    By promptResult = By.id("promptResult");
    By newTabButton = By.id("tabButton");

    public void openAlertsPage() {
        driver.get(ConfigReader.get("base.url") + "/alerts");
    }

    public void acceptSimpleAlert() {
        click(alertButton);
        driver.switchTo().alert().accept();
    }

    public void dismissConfirmAlert() {
        click(confirmButton);
        driver.switchTo().alert().dismiss();
    }

    public String getConfirmResult() {
        return getText(confirmResult);
    }

    public void enterPromptAlert(String text) {
        click(promptButton);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getPromptResult() {
        return getText(promptResult);
    }

    public void openBrowserWindowsPage() {
        driver.get(ConfigReader.get("base.url") + "/browser-windows");
    }

    public void openNewTabAndSwitch() {
        String parentWindow = driver.getWindowHandle();
        click(newTabButton);

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
}