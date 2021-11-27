import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirtsTest {

    @Test
    public void sdaWebPageTesting(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MSI\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://sdacademy.pl/");

        System.out.println(driver.findElement(By.className("heading-1")).getText());
        Assertions.assertEquals("Odważ się. Dokonaj zmiany.",driver.findElement(By.className("heading-1")).getText());

        driver.close();
    }

    @Test
    public void sdaFromGoogleTest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MSI\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.pl/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.findElement(By.name("q")).sendKeys("software development academy");
        driver.findElement(By.name("btnK")).submit();
        driver.findElement(By.xpath("//*[@id=\"tads\"]/div[1]/div/div/div[1]/a")).click();
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Wydarzenia - SDA Polska", driver.getTitle());

        driver.close();
    }
}