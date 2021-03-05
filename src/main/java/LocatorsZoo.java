import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsZoo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/chromedriver");
        WebDriver driver = null;
        try {
            driver =  new ChromeDriver();
            driver.navigate().to("https://spree-vapasi.herokuapp.com/");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            // locators
            //    Id
            driver.findElement(By.id("logo"));
            //    Name
            driver.findElement(By.name("taxon"));
            //    Linktext
            driver.findElement(By.linkText("Login"));
            //    Partial Linktext
            driver.findElement(By.partialLinkText("ogin"));
            //    Tag Name
            driver.findElement(By.tagName("select"));
            //    Class Name
            driver.findElement(By.className("btn-success"));
            //    CSS (Cascading Style Sheets)
            driver.findElement(By.cssSelector("#logo"));
            driver.findElement(By.cssSelector("[name='taxon']"));
            driver.findElement(By.cssSelector("select"));
            driver.findElement(By.cssSelector(".btn-success"));
            driver.findElement(By.cssSelector("#taxonomies > *"));
            driver.findElement(By.cssSelector("#taxonomies > *:nth-child(1)"));   // direct nth child under #taxonomies
            driver.findElement(By.cssSelector("#taxonomies > *:nth-child(2)"));
            driver.findElement(By.cssSelector("#taxonomies > *:nth-child(3)"));
            driver.findElement(By.cssSelector("#taxonomies > *:nth-child(4)"));

            driver.findElement(By.cssSelector("[id*='product_']"));
            driver.findElement(By.cssSelector("form input + div"));
            driver.findElement(By.cssSelector("form input ~ div"));
            driver.findElement(By.cssSelector("form input ~ *"));
            //    XPath
            driver.findElement(By.xpath("//*[@id='logo']"));
            driver.findElement(By.xpath("//select[@name='taxon']"));
            driver.findElement(By.xpath("//select"));
            driver.findElement(By.xpath("//input[@class='btn btn-success']"));
            driver.findElement(By.xpath("//input[contains(@class,'btn-success')]"));
            driver.findElement(By.xpath("//aside[@id='sidebar']/following-sibling::div"));
            driver.findElement(By.xpath("//nav[@id='taxonomies']/*"));
            driver.findElement(By.xpath("//nav[@id='taxonomies']/*[1]"));
            driver.findElement(By.xpath("//nav[@id='taxonomies']/*[2]"));
            driver.findElement(By.xpath("//nav[@id='taxonomies']/*[3]"));
            driver.findElement(By.xpath("//nav[@id='taxonomies']/*[4]"));
            driver.findElement(By.xpath("//h4[text()='Shop by Categories']"));
            driver.findElement(By.xpath("//h4[contains(text(),'by Categories')]"));
        } catch (Exception e){
            System.out.println("*********** exception ***********");
            System.out.println(e);
        }finally {
            driver.quit();
        }
    }

}
