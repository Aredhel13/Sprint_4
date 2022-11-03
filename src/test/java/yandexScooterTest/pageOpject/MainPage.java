package yandexScooterTest.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    //локатор первого вопроса в списке
    private static final String questionId = "accordion__heading-";
    private static final String answerId = ".//div[@id='accordion__panel-";
    //локатор кнопки "Заказать" вверху страницы
    public static final By orderButtonOnTop = By.className("Button_Button__ra12g");
    //окатор кнопки "Заказать" внизу страницы
    public static final By orderButtonOnBottom = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    //конструктор класса
    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    //открыть главную страницу
    public void openMainPage(){
        driver.get(url);
    }

    //получаем локатор вопроса
    public static By getQuestionLocator(int number){
//        String xpath = ;
        return By.id(questionId + number);
    }
    //получаем локатор ответа
    public static By getAnswerLocator(int number){
        return By.xpath(answerId + number +"']/p");

    }
    //кликнуть по элементу
    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    //получить текст ответа на вопрос
    public String getTextOfAnswer (By elementAnswer){
        return driver.findElement(elementAnswer).getText();
    }

    public void scroll(By path) {
        WebElement element = driver.findElement(path);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}

