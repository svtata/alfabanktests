package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class FormTests extends TestBase {

    MainPage mainPage = new MainPage();
    String errorText = "Телефон указан неверно. Должно быть 11 цифр, например: +7 (901) 123-45-67";

    @DisplayName("Проверка ошибки под полем Телефон")
    @Test
    void formErrorTest() {
        mainPage.clickOnTheButtonForPartners()
                .inputName("Иванов Иван")
                .inputEmail("test@mail.ru")
                .inputLink("http://test.com")
                .clickOnSubmit()
                .checkErrorText(errorText);
    }

}
