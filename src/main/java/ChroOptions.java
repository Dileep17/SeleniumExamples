import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class ChroOptions {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/chromedriver");
        WebDriver driver = null;
        try {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", System.getProperty("user.dir") + "/screenshots");
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.navigate().to("https://www.free-css.com/free-css-templates/page264/expertum");
            waitForPageToLoad(driver);

            driver.findElement(By.cssSelector(".divascookies-accept-button-text")).click();
            driver.findElement(By.cssSelector(".dld a")).click();

            Thread.sleep(3000);  // Bad way of waiting for file to download. Find dynamic ways.

        } catch (Exception e) {
            System.out.println("******* Exception *******");
            System.out.println(e);
        } finally {
            driver.quit();
        }
    }

    private static void waitForPageToLoad(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dld a")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".divascookies-accept-button-text")));
    }

}
