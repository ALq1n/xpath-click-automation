package clickautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

class XPathClickAutoTest {
    WebDriver driver;

    @BeforeAll static void setup() { WebDriverManager.chromedriver().setup(); }
    @BeforeEach void open() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterEach void quit() { if (driver != null) driver.quit(); }

    @Test void titleContainsSimsoft() {
        driver.get("https://www.simsoft.com.tr/en");
        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("simsoft"));
    }
}

