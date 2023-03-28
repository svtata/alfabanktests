package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.stream.Stream;

public class HeadersTests extends TestBase {

    MainPage mainPage = new MainPage();
    String mainHeader = "Подели — сервис оплаты покупок по частям";

    private static Stream<Arguments> advantagesHeaders() {
        return Stream.of(
                Arguments.of(0, "Для всех"),
                Arguments.of(1, "Чтобы расти и богатеть"),
                Arguments.of(2, "Мгновенно"),
                Arguments.of(3, "Без препятствий")
        );
    }

    @DisplayName("Проверка заголовка страницы на главном баннере")
    @Test
    void mainHeaderTest() {
        mainPage.checkHeaderIsVisible(mainHeader);
    }

    @DisplayName("Наличие блоков с преимуществами на главной странице сервиса")
    @MethodSource(value = "advantagesHeaders")
    @ParameterizedTest(name = "Проверка заголовка {1} в блоках с преимуществами")
    void checkAdvantagesTest(int x, String header) {
        mainPage.checkHeaderOfAdvantages(x, header);
    }

}
