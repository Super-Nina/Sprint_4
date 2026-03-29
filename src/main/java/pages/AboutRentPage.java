package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//страница про условия аренды
public class AboutRentPage {
    WebDriver driver;
//    локаторы
//    поле Когда привезти самокат
    By whenField = By.cssSelector("input[placeholder= '* Когда привезти самокат']");
//    для выбора дня в календаре
    String dayNumber;
    By date ;
//    поле Срок аренды
    By rentPeriod = By.xpath(".//div[@class='Dropdown-placeholder'][contains(text(), 'Срок аренды')]");
//    для выбора периода аренды
    String periodText;
    By period ;
//    для выбора цвета
    String colourText;
    By colour ;
//    поле комментария
    By commentField = By.cssSelector("input[placeholder= 'Комментарий для курьера']");
//    кнопка заказа под заполненной формой
    By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
//    кнопка Да (подтверждение заказа)
    By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(text(), 'Да')]");
//    сообщение Заказ оформлен
    By orderIsDone = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

//  получаем поле даты для шага
    public By getWhenField() {
        return whenField;
    }

    By getSelectedDate(String dayNumber) {
        return date = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--"+ dayNumber + " react-datepicker__day--outside-month']");
       }

//  получаем поле период для шага
        public By getPeriodField() {
            return rentPeriod;
        }
//  получаем выбранный период аренды для шага
    public By getSelectedPeriod(String periodText) {
        return period = By.xpath(".//div[@class='Dropdown-option'][contains(text(), '" + periodText +"')]");
    }

//    получаем выбранный цвет для шага
    public By getColour(String colourText) {
          return colour =By.xpath(".//input[@id='" +colourText+ "'][@class='Checkbox_Input__14A2w']");
}
//  получаем поле комментария для шага
    public By getCommentField() {
        return commentField;
    }

//    нажимаем Заказать
    public void pushOrderButton(){
        driver.findElement(orderButton).click();
    }

//    нажимаем Да
    public void pushYesButton(){
        driver.findElement(yesButton).click();
    }

//    проверяем, что появился текст Заказ оформлен
    public String textOrderIsDoneVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderIsDone));
        return driver.findElement(orderIsDone).getText();
    }
}