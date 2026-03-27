import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderButton_DownTest extends BaseUITest {

        @Test
//    проверка работоспособности кнопки Заказать внизу главной страницы
        public void orderButton_DownTest() {
            mainPage.openSite();
//  закрываем куки
            mainPage.closeCookeis();
//    прокручиваем до кнопки Заказать_нижней и нажимаем
            mainPage.checkOrderButton_Down();
//    проверяем видимость объекта со следующей страницы
            orderPage.isNextButtonVisible();

    assertTrue("Кнопки 'Далее' не видно", orderPage.isNextButtonVisible());
        }
}