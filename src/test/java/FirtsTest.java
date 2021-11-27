import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirtsTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MSI\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterAll
    public static void tearUp(){
        driver.quit();
    }

    @Test
    public void sdaWebPageTesting(){
        driver.get("https://sdacademy.pl/");

        System.out.println(driver.findElement(By.className("heading-1")).getText());
        Assertions.assertEquals("Odważ się. Dokonaj zmiany.",driver.findElement(By.className("heading-1")).getText());
    }

    @Test
    public void sdaFromGoogleTest(){
        driver.get("https://www.google.pl/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.findElement(By.name("q")).sendKeys("software development academy");
        driver.findElement(By.name("btnK")).submit();
        driver.findElement(By.xpath("//*[@id=\"tads\"]/div[1]/div/div/div[1]/a")).click();
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Wydarzenia - SDA Polska", driver.getTitle());
    }

    @Test
    public void wpLogin(){
        driver.get("https://profil.wp.pl/login/login.html");
        driver.findElement(By.name("login_username")).sendKeys("sdatesting");
        driver.findElement(By.name("password")).sendKeys("SDAtesting123!");
        driver.findElement(By.xpath("//*[@id=\"stgMain\"]/div/div/div[1]/form/button")).click();
        Assertions.assertEquals("Odebrane", driver.findElement(By.xpath("//*[@id=\"folder-1\"]/div[2]")).getText());
    }
}