package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class InfoPage {

    @Step("Проверяем, что открылась страница с подробной информацией")
    public InfoPage checkHeaderInfoPageIsVisible(String text) {
        $("[field='title']").shouldHave(text(text));
        return this;
    }

}
