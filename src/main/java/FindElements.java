import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

// Shop by Categories

public class FindElements {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.navigate().to("https://spree-vapasi.herokuapp.com/");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            List<WebElement> elements = driver.findElements(By.cssSelector("#taxonomies > div:nth-child(2) a"));

            // or
//            WebElement shopByCategory = driver.findElement(By.cssSelector("#taxonomies > div:nth-child(2)"));
//            List<WebElement> elements = shopByCategory.findElements(By.tagName("a"));

            System.out.println("Items that can be Shopped by Categories");
            for (WebElement element : elements){
                System.out.println(element.getText());
            }

        } catch (Exception e) {
            System.out.println("*********** exception ***********");
            System.out.println(e);
        } finally {
            driver.quit();
        }
    }

}
