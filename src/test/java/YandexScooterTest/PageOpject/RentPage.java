package YandexScooterTest.PageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    private WebDriver driver;
    //локатор поля "Когда привезти самокат"
    public By rentDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //локатор для поля "Срок аренды"
    public By rentTime = By.xpath(".//div[@class = 'Dropdown-control' and @aria-haspopup = 'listbox']");
    //локатор для выбора срока аренды из выпадающего списка
    public By rentTimeDetail = By.xpath((".//div[@class = 'Dropdown-option' and text() = 'сутки']"));
    //локатор для поля "Цвет самоката"
    public By blackColor = By.id("black");
    //локатор для поля "Комментарий"
    public By comment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //локатор кнопки "Заказать"
    private By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    //локатор кнопки "Да"
    private By confirmButtonYes = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1C SJM' and text() = 'Да']");
    //локатор текста "Заказ оформлен"
    private By orderProcessText = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");

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
