package pages;

import org.openqa.selenium.WebDriver;

public class Steps {
    WebDriver driver;
    MainPage mainPage; // добавляем экземпляр MainPage
    OrderPage orderPage;
    AboutRentPage aboutRentPage;

    public Steps(WebDriver driver, MainPage mainPage, OrderPage orderPage, AboutRentPage aboutRentPage) {
        this.driver = driver;
        this.mainPage = mainPage;
        this.orderPage = orderPage;
        this.aboutRentPage = aboutRentPage;
    }

    //    шаги для открытия сайта и нажатия на куки
    public void startOfWork(){
        openSite();
        closeCookeis();
    }
    // открываем сайт аренды
    public void openSite() {
        driver.get(mainPage.getSiteURL());
    }
    // нажимаем на куки
    public void closeCookeis() {
        driver.findElement(mainPage.getCookieButton()).click();
    }

//    шаг для заполнения полей при оформлении заказа
    public void fillTheFieldsOrderPage(String name, String lastname, String adress, String metro, String phone) {
        driver.findElement(orderPage.getNameField()).sendKeys(name);
        driver.findElement(orderPage.getLastnameField()).sendKeys(lastname);
        driver.findElement(orderPage.getAdressField()).sendKeys(adress);
        driver.findElement(orderPage.getMetroField()).sendKeys(metro);
        driver.findElement(orderPage.getSelectedMetroField()).click();
        driver.findElement(orderPage.getPhoneField()).sendKeys(phone);
    }
//     шаг для заполнения полей с информацией об аренде
    public void fillTheFieldsAboutRentPage(String date, String period, String colour, String comment) {
        driver.findElement(aboutRentPage.getWhenField()).click();
        driver.findElement(aboutRentPage.getSelectedDate(date)).click();
        driver.findElement(aboutRentPage.getPeriodField()).click();
        driver.findElement(aboutRentPage.getSelectedPeriod(period)).click();
        driver.findElement(aboutRentPage.getColour(colour));
        driver.findElement(aboutRentPage.getCommentField());
    }
}
