package com.github.dmitryalexeevi4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

class OverviewPage extends AbstractPage {
    private SelenideElement financialFreedom = $(By.xpath("//div[@id='can-spend']/span[@class = 'amount-holder']/span"));

    @Step("Проверка отображения блока \"Финансовая свобода\"")
    OverviewPage finBlockCheck() {
        $(new OverviewPage().financialFreedom.shouldBe(visible));
        return this;
    }

    @Step("Проверка указанной суммы на соответствие формату")
    OverviewPage amountFormatCheck() {
        $(new OverviewPage().financialFreedom.should(matchText("\\d{1,3}\\s\\d{3}\\s\\d{3}\\.\\d{2}\\s\\₽")));
        return this;
    }

    @Step("Проверка отображения \"Моих средств\"...")
    OverviewPage myAssetesCheck() {
        actions().moveToElement(new OverviewPage().financialFreedom).perform();
        $(new OverviewPage().findElementByClassName("my-assets").shouldBe(visible));
        return this;
    }

    @Step("Проверка указанной суммы на соответствие формату")
    OverviewPage myAssetsAmountFormatCheck() {
        $(new OverviewPage().findElementByClassName("my-assets").shouldHave(matchText("\\d{1,3}\\s\\d{3}\\s\\d{3}\\.\\d{2}\\s\\₽")));
        return this;
    }
}
