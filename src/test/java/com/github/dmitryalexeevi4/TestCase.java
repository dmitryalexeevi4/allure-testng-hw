package com.github.dmitryalexeevi4;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import org.testng.annotations.*;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.*;

@Epic("idemo.bspb.ru")
@Features(value = {@Feature(value = "Вход в систему"), @Feature(value = "Действия на странице")})
@Owner("Бобылев Дмитрий")

public class TestCase {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    OverviewPage overviewPage = new OverviewPage();

    @BeforeClass
    public void init() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open("https://idemo.bspb.ru");
    }

    @Feature(value = "Вход в систему")
    @Story("Проверка входа в систему")
    @Description("Здесь будет проверка въода в систему")
    @Test
    public void loginTest() {
        loginPage
                .fieldsInsert("demo", "demo")
                .authCheck()
                .codeInsert("0000");

        mainPage.userGreetingCheck();
    }

    @Feature(value = "Действия на страницах")
    @Story("Страница \"Overview\"")
    @Description("Здесь будут проверки на странице")
    @Test
    public void pageTest() {
        mainPage.openNavBarSection("overview");
        overviewPage.pageLocationCheck();

        overviewPage
                .finBlockCheck()
                .amountFormatCheck()
                .myAssetesCheck()
                .myAssetsAmountFormatCheck();
    }
}
