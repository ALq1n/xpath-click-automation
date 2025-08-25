package clickautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

@ExtendWith(AllureTestWatcher.class)
@DisplayName("Navigation Tests")
class XPathClickAutoTest {
    WebDriver driver;

    @BeforeAll static void setup() { WebDriverManager.chromedriver().setup(); }
    @BeforeEach void open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterEach void quit() { if (driver != null) driver.quit(); }

    @Test
    @DisplayName("Navigate to Contact page")
    void titleContainsSimsoft() {
        driver.get("https://www.simsoft.com.tr/en");
        // take screenshot before clicking
        AllureUtils.attachScreenshot(driver, "Before click: Contact");

        // click the Contact link
        driver.findElement(By.xpath("//a[contains(.,'Contact')]")).click();

        // take screenshot after clicking
        AllureUtils.attachScreenshot(driver, "After click: Contact");

        // your assertion
        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("contact"));
    }
}

