package YandexScooterTest.PageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    //локатор первого вопроса в списке
    private final By firstQuestionXpath = By.id("accordion__heading-0");
    //локатор второго вопроса в списке
    private final By secondQuestionXpath = By.id("accordion__heading-1");
    //локатор ответа на первый вопрос
    private final By firstAnswerXpath = By.xpath(".//div[@id='accordion__panel-0']/p");
    //локатор ответа на второй вопрос
    private final By secondAnswerXpath = By.xpath(".//div[@id='accordion__panel-1']/p");
    //локатор кнопки "Заказать" вверху страницы
    public static final By orderButtonOnTop = By.className("Button_Button__ra12g");
    //окатор кнопки "Заказать" внизу страницы
    public static final By orderButtonOnBottom = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    //конструктор класса
    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public By getFirstQuestionXpath() {
        return firstQuestionXpath;
    }

    public By getSecondQuestionXpath() {
        return secondQuestionXpath;
    }

    public By getFirstAnswerXpath() {
        return firstAnswerXpath;
    }

    public By getSecondAnswerXpath() {
        return secondAnswerXpath;
    }


    //открыть главную страницу
    public void openMainPage(){
        driver.get(url);
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

