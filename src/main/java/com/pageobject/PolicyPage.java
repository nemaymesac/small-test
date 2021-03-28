package com.pageobject;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PolicyPage extends PageObject {

    private static final String POLICY_PLANS_PATH = "//section//div[contains(normalize-space(@class), 'policy-item')]";

    public void waitUntilPageLoaded() {
        $x("//span[@id='page-one-travel']//main[@class='page-one-travel page-one-travel-policy']")
                .shouldBe(visible);
    }

    @Step("Get count of offered policies")
    public int getOfferedPolicyPlansCount() {
        return $$x(POLICY_PLANS_PATH).size();
    }

    @Step("Click to chose {value} policy")
    public void clickToChosePolicy(int id) {
        $x(POLICY_PLANS_PATH+"["+id+"]//button[@data-broadcast-one-wrapper='selectPolicyPlan']")
                .scrollTo()
                .shouldBe(visible)
                .click();
    }

    @Step("Submit button click")
    public void submitClick() {
        $x("//button[@data-broadcast-one-wrapper='submit']")
                .shouldBe(enabled)
                .click();
    }
}
