package Test;

import Pages.WebTablesPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    @Test
    public void addNewRowAndVerify() {


        page.openWebTablesPage();
        page.addNewRecord();

        Assert.assertTrue(page.isRecordDisplayed("Vijay"));
    }

    @Test
    public void searchRecordByName() {
        WebTablesPage page = new WebTablesPage(driver);

        page.openWebTablesPage();
        page.searchRecord("Cierra");

        Assert.assertTrue(page.isRecordDisplayed("Cierra"));
    }

    @Test
    public void deleteRecordAndVerify() {
        WebTablesPage page = new WebTablesPage(driver);

        page.openWebTablesPage();
        page.searchRecord("Cierra");
        page.deleteRecord();

        Assert.assertFalse(page.isRecordDisplayed("Cierra"));
    }

    @Test
    public void verifyPaginationButton() {
        WebTablesPage page = new WebTablesPage(driver);

        page.openWebTablesPage();

        Assert.assertTrue(page.isNextButtonDisplayed());
    }
}