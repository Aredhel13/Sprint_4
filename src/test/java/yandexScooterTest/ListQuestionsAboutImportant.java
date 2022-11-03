package yandexScooterTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import yandexScooterTest.pageOpject.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;

@RunWith(Parameterized.class)
public class ListQuestionsAboutImportant extends BaseTest {
    private final By questionPath;
    private final By answerPath;
    private final String expectedResult;

    public ListQuestionsAboutImportant(By questionPath, By answerPath, String expectedResult) {
        this.questionPath = questionPath;
        this.answerPath = answerPath;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {MainPage.getQuestionLocator(0), MainPage.getAnswerLocator(0), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.getQuestionLocator(1), MainPage.getAnswerLocator(1), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPage.getQuestionLocator(2), MainPage.getAnswerLocator(2), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPage.getQuestionLocator(3), MainPage.getAnswerLocator(3), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPage.getQuestionLocator(4), MainPage.getAnswerLocator(4), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPage.getQuestionLocator(5), MainPage.getAnswerLocator(5), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPage.getQuestionLocator(6), MainPage.getAnswerLocator(6), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPage.getQuestionLocator(7), MainPage.getAnswerLocator(7), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Test
    public void checkAnswerText(){

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.scroll(questionPath);
        mainPage.clickOnElement(questionPath);

        Assert.assertEquals(expectedResult, mainPage.getTextOfAnswer(answerPath));

    }

}