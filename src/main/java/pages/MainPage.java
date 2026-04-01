package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    WebDriver driver;
//    адрес сайта
    private static final String SITE_URL = "https://qa-scooter.praktikum-services.ru";
//    кнопка куки
    private By cookieButton = By.id("rcc-confirm-button");
//    кнопка Заказать_верхняя
    private By orderButtonUp = By.className("Button_Button__ra12g");
//    кнопка Заказать_нижняя
    private By orderButtonDown = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
//    кнопки с вопросами
    private By questionButtonRentPrice = By.id("accordion__heading-0");
    private By questionButtonFewSkates = By.id("accordion__heading-1");
    private By questionButtonRentTime = By.id("accordion__heading-2");
    private By questionButtonOrderToday = By.id("accordion__heading-3");
    private By questionButtonExtendRent = By.id("accordion__heading-4");
    private By questionButtonCharger = By.id("accordion__heading-5");
    private By questionButtonOrderCancel = By.id("accordion__heading-6");
    private By questionButtonDeliveryTerritory = By.id("accordion__heading-7");
//    кнопки с ответами
    private By answerButtonRentPrice = By.id("accordion__panel-0");
    private By answerButtonFewSkates = By.id("accordion__panel-1");
    private By answerButtonRentTime = By.id("accordion__panel-2");
    private By answerButtonOrderToday = By.id("accordion__panel-3");
    private By answerButtonExtendRent = By.id("accordion__panel-4");
    private By answerButtonCharger = By.id("accordion__panel-5");
    private By answerButtonOrderCancel = By.id("accordion__panel-6");
    private By answerButtonDeliveryTerritory = By.id("accordion__panel-7");

// массив с вопросами
    public By[] questions = {
        questionButtonRentPrice,
        questionButtonFewSkates,
        questionButtonRentTime,
        questionButtonOrderToday,
        questionButtonExtendRent,
        questionButtonCharger,
        questionButtonOrderCancel,
        questionButtonDeliveryTerritory
    };

//    массив с ответами
    public By[] answers = {
        answerButtonRentPrice,
        answerButtonFewSkates,
        answerButtonRentTime,
        answerButtonOrderToday,
        answerButtonExtendRent,
        answerButtonCharger,
        answerButtonOrderCancel,
        answerButtonDeliveryTerritory,
    };

// создаем драйвер
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //  открываем сайт аренды
    public void openSite() {
        driver.get(SITE_URL);
    }
    //  нажимаем на куки
    public void closeCookeis() {
        driver.findElement(cookieButton).click();
    }

//    скролл до кнопки 1-го вопроса
    public void scrollToQuestionButton() {
        WebElement webQuestionButton_1 = driver.findElement(questionButtonRentPrice);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webQuestionButton_1);
    }
//  нажимаем кнопки вопросов
    public void clickQuestionButton(int number) {
        By questionButton = By.id("accordion__heading-" + number);
        driver.findElement(questionButton).click();
    }
//    получаем текст вопроса
    public String getQuestionText(int number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(questions[number]));
        return driver.findElement(questions[number]).getText();
    }
//    получаем текст ответа
    public String getAnswerText(int number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answers[number]));
        return driver.findElement(answers[number]).getText();
    }

//нажимаем кнопку Заказать_верхнюю
    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
    }

//    для проверки работы кнопки Заказать-нижней
//    скролл до нее и нажимаем
    public void checkOrderButtonDown() {
        WebElement webOrderButton_Down = driver.findElement(orderButtonDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webOrderButton_Down);
        driver.findElement(orderButtonDown).click();
    }
}