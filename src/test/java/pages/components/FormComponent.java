package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormComponent {

    @Step("Вводим имя")
    public FormComponent inputName(String name) {
        $("[name='name']").sendKeys(name);
        return this;
    }

    @Step("Вводим email")
    public FormComponent inputEmail(String email) {
        $("[name='email']").sendKeys(email);
        return this;
    }

    @Step("Вводим ссылку")
    public FormComponent inputLink(String link) {
        $("[name='link']").sendKeys(link);
        return this;
    }

    @Step("Нажимаем отправить")
    public FormComponent clickOnSubmit() {
        $("[data-test-id='button']").$(byText("Отправить")).click();
        return this;
    }

    @Step("Проверяем текст ошибки под полем")
    public FormComponent checkErrorText(String text) {
        $("[data-test-id='captionError-']").shouldHave(text(text));
        return this;
    }

}
