package com.pageobject;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends PageObject {

    private static final String SIGN_IN_OPTION_PATH = "//button[@data-broadcast-one-wrapper='singUpOption']";

    public void waitUntilPageLoaded() {
        $x("//aside[@class='single-popup simple login']")
                .shouldBe(visible);
    }

    @Step("Get user sign in options")
    public int getUserSignInOptionCount() {
        waitUntilPageLoaded();

        return $$x(SIGN_IN_OPTION_PATH).size();
    }

    @Step("Sign in as guest click")
    public void signInAsGuestButtonClick() {
        waitUntilPageLoaded();

        $x("//div[@class='continue-as-guest-button']"+SIGN_IN_OPTION_PATH)
                .shouldBe(enabled)
                .click();
    }

}
