package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class InfoTests extends TestBase{

    MainPage mainPage = new MainPage();
    String headerInfo = "Информация о способах оплаты, а также правила оплаты по банковским картам";

    @DisplayName("Проверка перехода на страницу с подробной информацией")
    @Test
    void headerInfoServiceTest(){
        mainPage.clickOnInfoLink()
                .checkHeaderInfoPageIsVisible(headerInfo);
    }

    @DisplayName("Проверка корректности договора об оказании услуг  при скачивании")
    @Test
    void openAgreementOnNewTab() throws Exception{
        mainPage.downloadAndCheckAgreement();
    }

}
