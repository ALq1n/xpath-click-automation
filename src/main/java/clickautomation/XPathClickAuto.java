package clickautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class XPathClickAuto {
    public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    try {
        driver.get("https://www.simsoft.com.tr/en");

        // XPath ifadeleri
        String[] xpaths = {
                "//a[contains(text(),\"Home\")]",
                "//div[contains(@class, \"part\")]/ul[contains(@class, \"lvl0\")]/li[contains(@class, \"contact-page\")]/a"
        };

        // CSS Selector ifadeleri
        String[] cssSelectors = {
                "ul.lvl0 > li.career > a",
                "ul.lvl0 > li.solutions-page > a",
                "div.zone > div.zone > div.zone > div.zone > div.zone > div.part > div.items > div.item-container > div.item > a.cover-link"
        };

        //XPath tıklamaları
        for (String xpath : xpaths) {
            try {
                WebElement el = driver.findElement(By.xpath(xpath)); // Selenium element arama
                if (el.isDisplayed() && el.isEnabled()) {
                    el.click();
                    System.out.println("✅ XPath tıklandı: " + xpath);
                    Wait.wait(1000);
                    takeScreenshot(driver, "xpath_click");
                }
            } catch (Exception e) { // ❗ Bu Selenium hataları için
                System.out.println("❌ XPath tıklanamadı: " + xpath);
            }
        }

        //CSS tıklamaları
        for (String css : cssSelectors) {
            try {
                WebElement el = driver.findElement(By.cssSelector(css)); // Selenium element arama
                if (el.isDisplayed() && el.isEnabled()) {
                    el.click();
                    System.out.println("✅ CSS tıklandı: " + css);
                    Wait.wait(1000);
                    takeScreenshot(driver, "css_click");
                }
            } catch (Exception e) { // ❗ Bu Selenium hataları için
                System.out.println("❌ CSS tıklanamadı: " + css);
            }
        }

    } finally {
        Wait.wait(5000);
        driver.quit();
    }
}

    // Ekran görüntüsü alma fonksiyonu
    public static void takeScreenshot(WebDriver driver, String label) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File dest = new File("screenshots/" + label + "_" + timestamp + ".png");

        dest.getParentFile().mkdirs(); // Klasör yoksa oluştur

        try {
            Files.copy(screenshot.toPath(), dest.toPath());
            System.out.println("📸 Ekran görüntüsü kaydedildi: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Ekran görüntüsü kaydedilemedi: " + e.getMessage());
        }
    }
}
