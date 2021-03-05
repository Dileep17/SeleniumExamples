import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WDActions {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/chromedriver");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.navigate().to("https://spree-vapasi.herokuapp.com/");
            waitForPageToLoad(driver);

            WebElement loginLink = driver.findElement(By.linkText("Login"));
            Actions actions = new Actions(driver);
            actions.moveToElement(loginLink).click().build().perform();

            Thread.sleep(3000);  // adding this so that you can see the login page
        } catch (Exception e){
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
