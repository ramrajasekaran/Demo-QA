package utils;

import configuration.ConfigReader;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = ConfigReader.get("screenshot.dir") + "/" + testName + ".png";
        File dest = new File(path);

        try {
            dest.getParentFile().mkdirs();
            Files.copy(
                    src.toPath(),
                    dest.toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}