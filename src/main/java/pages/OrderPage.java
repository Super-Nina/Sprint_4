package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    WebDriver driver;
    //    локаторы
    //    поле Имя
    private By nameField = By.cssSelector("input[placeholder='* Имя']");
    //    поле Фамилия
    private By lastnameField = By.cssSelector("input[placeholder='* Фамилия']");
    //    поле адрес
    private By adressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    //    поле метро
    private By metroField = By.cssSelector("input[placeholder='* Станция метро']");
    private By selectedMetro = By.className("select-search__select");
    //    поле телефон
    private By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //    кнопка Далее
    private By nextButton = By.xpath(".//button[text()='Далее']");

    //    создаем драйвер
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
// получаем поле имени для шага
    public By getNameField() {
        return nameField;
    }
// получаем поле фамилии для шага
    public By getLastnameField() {
        return lastnameField;
    }
// получаем поле адреса для шага
    public By getAdressField() {
        return adressField;
    }
// получаем поле метро для шага
    public By getMetroField() {
        return metroField;
    }
// получаем выбранное метро для шага
    public By getSelectedMetroField() {
        return selectedMetro;
    }
// получаем поле телефон для шага
    public By getPhoneField() {
        return phoneField;
    }

//нажимаем кнопку далее
    public void pushNextButton() {
        driver.findElement(nextButton).click();
    }

// Для теста кнопки Заказать(нижняя)
//    проверяем видимость кнопки Далее после нажатия кнопки Заказать(нижняя) на гл.странице
    public boolean isNextButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        boolean isNextButtonVisible =  driver.findElement(nextButton).isDisplayed();
        return isNextButtonVisible;
    }
}







