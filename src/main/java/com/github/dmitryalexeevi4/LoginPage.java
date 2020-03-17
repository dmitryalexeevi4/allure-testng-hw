package com.github.dmitryalexeevi4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
@Feature("Страница Логина")
class LoginPage extends AbstractPage {
    private SelenideElement usernameField = $(By.name("username"));
    private SelenideElement passwordField = $(By.name("password"));
    private SelenideElement otpCodeField = $(By.name("otpCode"));

    @Step("Логирование пользователя {username} / {password}")
    LoginPage fieldsInsert(String username, String password) {
        usernameField.clear();
        usernameField.setValue(username);
        passwordField.clear();
        passwordField.setValue(password);
        buttonClick("login-button");
        return this;
    }

    @Step("Ввод кода двухфакторной авторизации")
    LoginPage codeInsert(String code) {
        otpCodeField.clear();
        otpCodeField.setValue(code);
        buttonClick("login-otp-button");
        return this;
    }

    @Step("Проверка на отображение формы двухфакторной авторизации")
    LoginPage authCheck() {
        $(new LoginPage().findElementById("login-form").shouldBe(visible));
        return this;
    }


}
