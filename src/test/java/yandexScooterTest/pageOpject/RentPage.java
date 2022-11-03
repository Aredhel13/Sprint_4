package yandexScooterTest.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    private WebDriver driver;
    //локатор поля "Когда привезти самокат"
    private final By rentDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //локатор для поля "Срок аренды"
    private final By rentTime = By.xpath(".//div[@class = 'Dropdown-control' and @aria-haspopup = 'listbox']");
    //локатор для выбора срока аренды из выпадающего списка
    private final By rentTimeDetail = By.xpath((".//div[@class = 'Dropdown-option' and text() = 'сутки']"));
    //локатор для поля "Цвет самоката"
    private final By blackColor = By.id("black");
    //локатор для поля "Комментарий"
    private final By comment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    //локатор кнопки "Да"
    private final By confirmButtonYes = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    //локатор текста "Заказ оформлен"
    private final By orderProcessText = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");

    public RentPage (WebDriver driver){
        this.driver = driver;
    }

    public void inputValuesInRentFormAndCreateOrder(String date, String userComment){
        driver.findElement(rentDate).sendKeys(date);
        driver.findElement(rentDate).sendKeys(Keys.ENTER);
        driver.findElement(rentTime).click();
        driver.findElement(rentTimeDetail).click();
        driver.findElement(blackColor).click();
        driver.findElement(comment).sendKeys(userComment);
        driver.findElement(orderButton).click();
        driver.findElement(confirmButtonYes).click();
    }

    public String getTextFromOrderProcessedWindow(){
        return driver.findElement(orderProcessText).getText();
    }
}
