package yandexScooterTest;

import yandexScooterTest.pageOpject.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)
public class ScooterOrder extends BaseTest{
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String userPhoneNumber;
    private final String orderDate;
    private final String comment;
    private final By orderButton;

    public ScooterOrder(String userName, String userSurname, String userAddress, String userPhoneNumber, String orderDate, String comment, By orderButton) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.orderDate = orderDate;
        this.comment = comment;
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { "Какаши", "Хатаке", "Коноха", "88002253535", "10.11.2022", "Шестой хокаге", MainPage.orderButtonOnTop},
                { "Ичиго", "Куросаки", "Готей", "88002225555", "13.11.2022", "Самый крутой", MainPage.orderButtonOnTop},
                { "Тоширо", "Хицугая", "Готей 13", "88005553535", "09.11.2022", "Капитан десятого отряда", MainPage.orderButtonOnBottom},
                { "Сасаки", "Мияно", "Манга", "88005522525", "20.11.2022", "Милота", MainPage.orderButtonOnBottom},
        };
    }


    @Test
    public void checkOrderProcess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.scroll(orderButton);
        mainPage.clickOnElement(orderButton);

        ForWhomScooterPage forWhomScooterPage = new ForWhomScooterPage(driver);
        forWhomScooterPage.inputValuesInFormUserDataAndClickNext(userName,userSurname,userAddress,userPhoneNumber);

        RentPage rentPage = new RentPage(driver);
        rentPage.inputValuesInRentFormAndCreateOrder(orderDate, comment);
        Assert.assertTrue(rentPage.getTextFromOrderProcessedWindow().contains("Заказ оформлен"));

    }

}
