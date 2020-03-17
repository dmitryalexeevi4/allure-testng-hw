package com.github.dmitryalexeevi4;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class MainPage extends AbstractPage {
    @Step("Проверка на отображение приветствия пользователя")
    MainPage userGreetingCheck() {
        $(new MainPage().findElementById("user-greeting").shouldBe(visible));
        return this;
    }
}
