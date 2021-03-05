import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.sql.Timestamp;

public class ScreenShots {

//    import commons-io dependency for FileUtils

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/chromedriver");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.navigate().to("https://spree-vapasi.herokuapp.com/");
            waitForPageToLoad(driver);

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshots/"+new Timestamp(System.currentTimeMillis())+".png"));

            driver.findElement(By.linkText("Login")).click();
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshots/"+new Timestamp(System.currentTimeMillis())+".png"));


        } catch (Exception e) {
            System.out.println("******* Exception *******");
            System.out.println(e);
        } finally {
            driver.quit();
        }
    }

    private static void waitForPageToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
    }

}
