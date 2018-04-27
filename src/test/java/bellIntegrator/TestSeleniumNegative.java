package bellIntegrator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class TestSeleniumNegative {
    private static WebDriver driver;
    private static String base_url;

    @BeforeClass
    public static void startWebDriver() {
        System.setProperty("webdriver.gecko.driver", "E:/Program Files/geckodriver.exe");
        base_url = "https://yandex.ru";
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(base_url);
    }

    @Test
    public void WebDriverNegativeTest() {

        driver.get(base_url);

        driver.findElement(By.id("text")).sendKeys("vbvbvbvbvbvbbvbvbvbvbvbvbvbvbsbvhbasdfljvhbldjasfhbvljsdhbfvlhsdbflvhbsdljfvhbsldhfbvlsdhbfvjlhsbdfljvhbsdlfv");

        WebElement find = driver.findElement(By.className("search2__button")).findElement(By.tagName("button"));
        find.click();

        if (driver.findElement(By.className("misspell__message")).getText().contains("По вашему запросу ничего не нашлось") == true) {
            System.out.println("Cool!");
        }
    }

    @AfterTest
    public void theEnd() {
        driver.quit();
    }
}
