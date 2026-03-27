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
    private By orderButton_Up = By.className("Button_Button__ra12g");
//    кнопка Заказать_нижняя
    private By orderButton_down = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
//    кнопки с вопросами
    private By questionButton_1 = By.id("accordion__heading-0");
    private By questionButton_2 = By.id("accordion__heading-1");
    private By questionButton_3 = By.id("accordion__heading-2");
    private By questionButton_4 = By.id("accordion__heading-3");
    private By questionButton_5 = By.id("accordion__heading-4");
    private By questionButton_6 = By.id("accordion__heading-5");
    private By questionButton_7 = By.id("accordion__heading-6");
    private By questionButton_8 = By.id("accordion__heading-7");
//    кнопки с ответами
    private By answerButton_1 = By.id("accordion__panel-0");
    private By answerButton_2 = By.id("accordion__panel-1");
    private By answerButton_3 = By.id("accordion__panel-2");
    private By answerButton_4 = By.id("accordion__panel-3");
    private By answerButton_5 = By.id("accordion__panel-4");
    private By answerButton_6 = By.id("accordion__panel-5");
    private By answerButton_7 = By.id("accordion__panel-6");
    private By answerButton_8 = By.id("accordion__panel-7");

// массив с вопросами
    public By[] questions = {
            questionButton_1,
            questionButton_2,
            questionButton_3,
            questionButton_4,
            questionButton_5,
            questionButton_6,
            questionButton_7,
            questionButton_8
    };

//    массив с ответами
    public By[] answers = {
            answerButton_1,
            answerButton_2,
            answerButton_3,
            answerButton_4,
            answerButton_5,
            answerButton_6,
            answerButton_7,
            answerButton_8,
    };

// создаем драйвер
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
//  нажимаем на куки
    public void closeCookeis() {
        driver.findElement(cookieButton).click();
    }
//  открываем сайт аренды
    public void openSite() {
        driver.get(SITE_URL);
    }
//    скролл до кнопки 1-го вопроса
    public void scrollToQuestionButton_1() {
        WebElement webQuestionButton_1 = driver.findElement(questionButton_1);
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
    public void clickOrderButton_Up() {
        driver.findElement(orderButton_Up).click();
    }

//    для проверки работы кнопки Заказать-нижней
//    скролл до нее и нажимаем
    public void checkOrderButton_Down() {
        WebElement webOrderButton_Down = driver.findElement(orderButton_down);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webOrderButton_Down);
        driver.findElement(orderButton_down).click();
    }
}