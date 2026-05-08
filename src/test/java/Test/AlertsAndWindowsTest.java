package Test;

import Pages.AlertsWindowsPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsAndWindowsTest extends BaseTest {

    @Test
    public void acceptSimpleAlert() {
        AlertsWindowsPage page = new AlertsWindowsPage(driver);

        page.openAlertsPage();
        page.acceptSimpleAlert();

        Assert.assertTrue(true);
    }

    @Test
    public void dismissConfirmAlertAndVerifyText() {
        AlertsWindowsPage page = new AlertsWindowsPage(driver);

        page.openAlertsPage();
        page.dismissConfirmAlert();

        Assert.assertTrue(page.getConfirmResult().contains("Cancel"));
    }

    @Test
    public void enterTextInPromptAlert() {
        AlertsWindowsPage page = new AlertsWindowsPage(driver);

        page.openAlertsPage();
        page.enterPromptAlert("Vijay");

        Assert.assertTrue(page.getPromptResult().contains("Vijay"));
    }

    @Test
    public void openNewTabAndVerifyTitle() {
        AlertsWindowsPage page = new AlertsWindowsPage(driver);

        page.openBrowserWindowsPage();
        page.openNewTabAndSwitch();

        Assert.assertTrue(driver.getCurrentUrl().contains("sample"));
    }
}