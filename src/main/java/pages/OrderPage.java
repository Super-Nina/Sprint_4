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
    //    поле телефон
    private By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //    кнопка Далее
    private By nextButton = By.xpath(".//button[text()='Далее']");

    //    создаем драйвер
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //вводим имя
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    //вводим фамилию
    public void setLastName(String lastName) {
        driver.findElement(lastnameField).sendKeys(lastName);
    }
    //вводим адрес
    public void setAdress(String adress) {
        driver.findElement(adressField).sendKeys(adress);
    }
    //выбираем метро
    public void setMetro(String metro) {
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(By.className("select-search__select")).click();
    }
    //вводим телефон
    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
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







