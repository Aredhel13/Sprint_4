package yandexScooterTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Lenovo/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.firefox.driver","C:/Users/Lenovo/WebDriver/bin/geckodriver.exe");
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void teardown(){
        driver.quit();
    }

}
