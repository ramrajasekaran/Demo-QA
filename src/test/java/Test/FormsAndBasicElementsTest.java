package Test;

import Pages.PracticeFormPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsAndBasicElementsTest extends BaseTest {

    @Test
    public void fillPracticeFormWithValidData() {
        PracticeFormPage page = new PracticeFormPage(driver);

        page.openPracticeForm();
        page.fillValidForm();
        page.submitForm();

        Assert.assertTrue(page.isSubmissionSuccessful());
    }

    @Test
    public void submitFormWithEmptyMandatoryFields() {
        PracticeFormPage page = new PracticeFormPage(driver);

        page.openPracticeForm();
        page.submitForm();

        Assert.assertTrue(page.isFirstNameErrorDisplayed());
    }
}