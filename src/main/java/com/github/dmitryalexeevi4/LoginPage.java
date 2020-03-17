package com.github.dmitryalexeevi4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.$;

class LoginPage extends AbstractPage {
    private SelenideElement usernameField = $(By.name("username"));
    private SelenideElement passwordField = $(By.name("password"));
    private SelenideElement otpCodeField = $(By.name("otpCode"));

    LoginPage fieldsInsert(String username, String password) {
        usernameField.clear();
        usernameField.setValue(username);
        passwordField.clear();
        passwordField.setValue(password);
        return this;
    }

    LoginPage codeInsert(String code) {
        otpCodeField.clear();
        otpCodeField.setValue(code);
        return this;
    }

    LoginPage loginButton(String buttonId) {
        findElementById(buttonId).click();
        return this;
    }
}
