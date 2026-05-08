package Test;

import Pages.FramesPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void switchToIframeAndVerifyText() {
        FramesPage page = new FramesPage(driver);

        page.openFramesPage();
        page.switchToFrameOne();

        Assert.assertEquals(page.getFrameText(), "This is a sample page");
    }

    @Test
    public void verifyTextInsideNestedIframe() {
        FramesPage page = new FramesPage(driver);

        page.openNestedFramesPage();

        Assert.assertEquals(page.getNestedFrameText(), "Child Iframe");
    }

    @Test
    public void switchBackToMainFrame() {
        FramesPage page = new FramesPage(driver);

        page.openFramesPage();
        page.switchToFrameOne();
        page.switchToMainPage();

        Assert.assertTrue(driver.getCurrentUrl().contains("frames"));
    }
}