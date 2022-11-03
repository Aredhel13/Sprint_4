package yandexScooterTest.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ForWhomScooterPage {
    WebDriver driver;
    //локатор для поля "Имя"
    private final By name = By.xpath(".//input[@placeholder = '* Имя']");
    //локатор для поля "Фамилия"
    private final By surname = By.xpath(".//input[@placeholder = '* Фамилия']");
    //локатор для поля "Адрес"
    private final By address = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //локатор для поля "Станция метро"
    private final By metroStation = By.xpath(".//input[@placeholder = '* Станция метро']");
    //локатор конкретной станции метро
    private final By metroStationSocolniki = By.xpath(".//div[@class = 'select-search__select']/ul/li/button[@value = '1']"); ///div[@class = 'Order_Text_2broi' and text() = 'Сокольники']
    //локатор для поля "Телефон"
    private final By phone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private final By nextButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор куки
    private final By cookies = By.id("rcc-confirm-button");


    public ForWhomScooterPage (WebDriver driver){
        this.driver = driver;
    }

    public void clickOnButton(By button){
        driver.findElement(button).click();
    }

    public void inputValuesInFormUserDataAndClickNext(String userName, String userSurname, String userAddress, String userPhone){
        driver.findElement(name).sendKeys(userName);
        driver.findElement(surname).sendKeys(userSurname);
        driver.findElement(address).sendKeys(userAddress);
        driver.findElement(metroStation).click();
        driver.findElement(metroStationSocolniki).click();
        driver.findElement(phone).sendKeys(userPhone);
        driver.findElement(cookies).click();
        clickOnButton(nextButton);
    }

}
