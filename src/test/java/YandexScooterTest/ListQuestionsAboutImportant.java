package YandexScooterTest;

import YandexScooterTest.PageOpject.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;


public class ListQuestionsAboutImportant {
    WebDriver driver;
    private String expectedResult;


    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Lenovo/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void checkAnswerTextOnFirstQuestion(){

        expectedResult = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        By questionPath = mainPage.getFirstQuestionXpath();
        mainPage.scroll(questionPath);
        mainPage.clickOnElement(questionPath);

        Assert.assertEquals(expectedResult, mainPage.getTextOfAnswer(mainPage.getFirstAnswerXpath()));

    }

    @Test
    public void checkAnswerTextOnSecondQuestion(){

        expectedResult = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        By questionPath = mainPage.getSecondQuestionXpath();
        mainPage.scroll(questionPath);
        mainPage.clickOnElement(questionPath);

        Assert.assertEquals(expectedResult, mainPage.getTextOfAnswer(mainPage.getSecondAnswerXpath()));

    }


    @After
    public void teardown(){
        driver.quit();
    }
}