package com.github.dmitryalexeevi4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

abstract class AbstractPage {

    String firstTitleWord() {
        return title().substring(0, title().indexOf(' '));
    }

    SelenideElement pageHeader() {
        return $(By.xpath("//div[@class = 'page-header']/h1"));
    }

    @Step("Открытие секции {sectionId}")
    AbstractPage openNavBarSection(String sectionId) {
        $(By.xpath("//ul[@class = 'navigation-menu nav']//li[@id = '" + sectionId + "']")).click();
        return this;
    }

    @Step("Проверка нахождения на странице")
    AbstractPage pageLocationCheck() {
        $(pageHeader().shouldHave(text(firstTitleWord())));
        return this;
    }

    SelenideElement findElementByClassName(String className) {
        return $(By.className(className));
    }

    SelenideElement findElementById(String id) {
        return $(By.id(id));
    }

    public void buttonClick(String buttonId) {
        findElementById(buttonId).click();
    }
}
