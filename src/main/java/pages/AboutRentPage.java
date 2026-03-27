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
//    для выбора даты
//    By date = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--001 react-datepicker__day--outside-month']");
//    поле Срок аренды
    By rentPeriod = By.xpath(".//div[@class='Dropdown-placeholder'][contains(text(), 'Срок аренды')]");
//    для выбора периода
//    By period = By.xpath(".//div[@class='Dropdown-option'][contains(text(), 'двое суток')]");
//    для выбора цвета
//    By colour =By.xpath(".//input[@id='black'][@class='Checkbox_Input__14A2w']");
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
// заполняем поле с датой аренды
    String dayNumber;
    public void setWhenField (String dayNumber){
        By date = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--" + dayNumber +  " react-datepicker__day--outside-month']");
        driver.findElement(whenField).click();
        driver.findElement(date).click();
    }

//    заполняем поле с периодом аренды
    String periodText;
    public void setRentPeriod (String periodText){
        driver.findElement(rentPeriod).click();
        By period = By.xpath(".//div[@class='Dropdown-option'][contains(text(), '" + periodText +"')]");
        driver.findElement(period).click();
    }

//    выбираем цвет
    String colourText;
    public void setColour(String colourText){
        By colour =By.xpath(".//input[@id='" +colourText+ "'][@class='Checkbox_Input__14A2w']");
        driver.findElement(colour).click();
    }
//    добавляем комментарий
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
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