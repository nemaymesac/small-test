package com.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static util.ConfigHelper.getBaseUrl;

public class MainPage extends PageObject {

    private static final String HEADER_BUTTONS_PATH = "//div[@class='list']/child::a//h4[contains(text(),'%s')]";
    private static final String LANGUAGE_BUTTON_PATH = "//div[@class='lang-buttons']//a[contains(normalize-space(.), '%s')]";

    @Step("Navigate to website")
    public MainPage navigate() {
        String Url = getBaseUrl();
        Selenide.open(Url);
        return this;
    }

    @Step("Ribbon menu {option} button click")
    public void ribbonMenuButtonClick(String option) {
        SelenideElement element = $x(String.format(HEADER_BUTTONS_PATH, option));
        if (element.exists()) {
            element.scrollIntoView(true);
        }

        element.click();
    }

    @Step("Click on page logo")
    public void logoClick() {
        $x("//a[@class='logo']")
                .click();
    }

    @Step("Language {option} button click")
    public void languageButtonClick(String option) {
        SelenideElement element = $x(String.format(LANGUAGE_BUTTON_PATH, option));
        if (element.exists()) {
            element.scrollIntoView(true);
        }

        element.click();
    }
}
