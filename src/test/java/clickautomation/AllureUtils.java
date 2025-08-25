package clickautomation;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public final class AllureUtils {
    private AllureUtils() {}

    public static void attachScreenshot(WebDriver driver, String name) {
        if (driver == null) return;
        try {
            byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name == null ? "screenshot" : name,
                    "image/png", new ByteArrayInputStream(png), "png");
        } catch (Throwable ignored) {}
    }

    public static void attachPageSource(WebDriver driver, String name) {
        if (driver == null) return;
        try {
            String src = driver.getPageSource();
            Allure.addAttachment(name == null ? "page-source" : name,
                    "text/html", new ByteArrayInputStream(src.getBytes(StandardCharsets.UTF_8)), "html");
        } catch (Throwable ignored) {}
    }
}

