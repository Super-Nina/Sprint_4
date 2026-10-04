import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderButtonDownTest extends BaseUITest {

        @Test
//    проверка работоспособности кнопки Заказать внизу главной страницы
        public void orderButtonDownTest() {
//  открываем сайт и нажимаем куки, используя шаги
            steps.startOfWork();
//    прокручиваем до кнопки Заказать_нижней и нажимаем
            mainPage.checkOrderButtonDown();
//    проверяем видимость объекта со следующей страницы
            orderPage.isNextButtonVisible();

    assertTrue("Кнопки 'Далее' не видно", orderPage.isNextButtonVisible());
        }
}