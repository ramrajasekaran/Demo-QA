package Test;

import Pages.WidgetsPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WidgetsTest extends BaseTest {

    @Test
    public void selectDateAndVerify() {
        WidgetsPage page = new WidgetsPage(driver);

        page.openDatePickerPage();
        page.selectDate("05/08/2026");

        Assert.assertEquals(page.getSelectedDate(), "05/08/2026");
    }

    @Test
    public void moveSliderAndVerifyValueChanges() {
        WidgetsPage page = new WidgetsPage(driver);

        page.openSliderPage();
        String beforeValue = page.getSliderValue();

        page.moveSlider();

        String afterValue = page.getSliderValue();
        Assert.assertNotEquals(beforeValue, afterValue);
    }

    @Test
    public void interactWithAccordion() {
        WidgetsPage page = new WidgetsPage(driver);

        page.openAccordionPage();

        Assert.assertTrue(page.isSectionOneDisplayed());
    }
}