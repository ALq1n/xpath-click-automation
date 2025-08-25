package clickautomation;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

public class AllureTestWatcher implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override public void beforeTestExecution(ExtensionContext ctx) { /* optional: mark step start */ }

    @Override
    public void afterTestExecution(ExtensionContext ctx) {
        boolean failed = ctx.getExecutionException().isPresent();
        if (!failed) return;

        WebDriver driver = findWebDriver(ctx.getRequiredTestInstance());
        if (driver != null) {
            AllureUtils.attachScreenshot(driver, "Failure screenshot");
            AllureUtils.attachPageSource(driver, "Failure page source");
        }
    }

    /** Try to find a WebDriver field on the test instance */
    private WebDriver findWebDriver(Object testInstance) {
        try {
            Class<?> c = testInstance.getClass();
            while (c != Object.class) {
                for (Field f : c.getDeclaredFields()) {
                    if (WebDriver.class.isAssignableFrom(f.getType())) {
                        f.setAccessible(true);
                        Object v = f.get(testInstance);
                        if (v instanceof WebDriver) return (WebDriver) v;
                    }
                }
                c = c.getSuperclass();
            }
        } catch (Throwable ignored) {}
        return null;
    }
}
