package pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import pages.components.FormComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    @Step("Проверяем, что заголовок виден")
    public MainPage checkHeaderIsVisible(String header) {
        $("[data-test-id='mainBanner']").shouldBe(text(header)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Кликаем на кнопку \"Стать парнером\"")
    public FormComponent clickOnTheButtonForPartners() {
        $("[data-widget-name='ButtonV2']").click();
        return new FormComponent();
    }

    @Step("Кликаем на ссылку для получения информации о сервисе")
    public InfoPage clickOnInfoLink() {
        $("a[href=\"https://podeli.ru/info\"]").click();
        return new InfoPage();
    }

    @Step("Скачиваем договор об оказании услуг и проверяем содержимое")
    public void downloadAndCheckAgreement() throws Exception {
        File file = $("a[href*=\"dogovor-ob-okazanii\"]").download();
        PDF pdf = new PDF(file);
        Assertions.assertThat(pdf.text).contains("Договор об оказании услуг по привлечению клиентов");
    }

    @Step("Проверяем заголовок блока {header}")
    public MainPage checkHeaderOfAdvantages(int x, String header) {
        $$("[data-test-id='tile-heading']").get(x).shouldHave(text(header));
        return this;
    }

}
