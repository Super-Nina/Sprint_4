import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ParamOrderTest extends BaseUITest{
    String name;
    String lastname;
    String adress;
    String metro;
    String phone;
    String date;
    String period;
    String colour;
    String comment;

    public ParamOrderTest(String name, String lastname, String adress, String metro, String phone, String date, String period, String colour, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Набор данных #{0}")
    public static Object[] getText() {
        return new Object[][]{
                {"Нина", "Иванова", "Москва, Кремль", "Печатники", "12223334455", "001", "двое суток", "black", "привозите скорее!"},
                {"Мальвина", "Чудакова", "Санкт-Петербург", "Зябликово", "98887776655", "003", "сутки", "grey", "Очень жду!"}
        };
    }
 @Test
 public void makeOrderTest(){
//  открываем сайт
     mainPage.openSite();
//  закрываем куки
     mainPage.closeCookeis();
 // нажимаем верхную кнопку заказа
     mainPage.clickOrderButton_Up();

//  заполняем поля данными из параметров
     orderPage.setName(name);
     orderPage.setLastName(lastname);
     orderPage.setAdress(adress);
     orderPage.setMetro(metro);
     orderPage.setPhoneField(phone);
     orderPage.pushNextButton();
     aboutRentPage.setWhenField(date);
     aboutRentPage.setRentPeriod(period);
     aboutRentPage.setColour(colour);
     aboutRentPage.setComment(comment);

//  нажимаем кнопку заказать под формой
     aboutRentPage.pushOrderButton();
//  нажимаем Да (подтверждение)
     aboutRentPage.pushYesButton();
//ждем, что появится окно с подтверждением оформления заказа
    String actualText = aboutRentPage.textOrderIsDoneVisible();
    assertTrue("заказ не оформлен", actualText.contains("Заказ оформлен"));
    }
}




