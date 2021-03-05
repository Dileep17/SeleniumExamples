import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsDisplayed {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/chromedriver");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.navigate().to("https://spree-vapasi.herokuapp.com/");
            waitForPageToLoad(driver);

            WebElement loginLink = driver.findElement(By.linkText("Login"));
            System.out.println("Login link is visible: " + loginLink.isDisplayed());
            loginLink.click();

            System.out.println("is username text field enabled : " + driver.findElement(By.id("spree_user_email")).isEnabled());
            System.out.println("Is remember me selected : " + driver.findElement(By.id("spree_user_remember_me")).isSelected());

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
