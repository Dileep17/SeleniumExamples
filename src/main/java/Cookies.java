import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cookies {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/chromedriver");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.navigate().to("https://spree-vapasi.herokuapp.com/");
            waitForPageToLoad(driver);

            System.out.println("value of token cookie = " + driver.manage().getCookieNamed("token"));
            driver.manage().deleteCookieNamed("token");
            System.out.println("value of token cookie = " + driver.manage().getCookieNamed("token"));


            WebStorage webStorage = (WebStorage)driver;
            webStorage.getLocalStorage().getItem("xyx");
            webStorage.getLocalStorage().clear();
//
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
