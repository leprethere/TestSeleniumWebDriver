package bellIntegrator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class TestSelenium {
    private static WebDriver driver;
    private static String base_url_yandex;

    @BeforeClass
    public static void startWebDriver() {
        System.setProperty("webdriver.gecko.driver", "E:/Program Files/geckodriver.exe");
        base_url_yandex = "https://yandex.ru";
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(base_url_yandex);
    }

    @Test
    public void WebDriverTest() {

        driver.get(base_url_yandex);

        driver.findElement(By.id("text")).sendKeys("bell integrator");

        WebElement find = driver.findElement(By.className("search2__button")).findElement(By.tagName("button"));
        find.click();

        if (driver.findElements(By.className("organic__url-text")).size() >  3) {
            System.out.println("Cool!");

        } else {
            System.out.println("I can't find 3 elements");
        }

    }

    @AfterTest
    public void theEnd() {
        driver.quit();
    }
}