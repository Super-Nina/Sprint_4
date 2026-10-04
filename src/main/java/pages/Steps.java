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
        mainPage.openSite();
        mainPage.closeCookeis();
    }
//    шаг для заполнения полей при оформлении заказа
    public void fillTheFieldsOrderPage(String name, String lastname, String adress, String metro, String phone) {
        orderPage.setName(name);
        orderPage.setLastName(lastname);
        orderPage.setAdress(adress);
        orderPage.setMetro(metro);
        orderPage.setPhone(phone);
    }
//     шаг для заполнения полей с информацией об аренде
    public void fillTheFieldsAboutRentPage(String date, String period, String colour, String comment) {
        aboutRentPage.setWhenField(date);
        aboutRentPage.setRentPeriod(period);
        aboutRentPage.setColour(colour);
        aboutRentPage.setComment(comment);
    }
}
