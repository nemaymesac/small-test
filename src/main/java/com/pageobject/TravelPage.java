package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static util.WebElementUtil.getText;

public class TravelPage extends PageObject {

    private static final String REGION_BUTTON_PATH = "//div[@data-store='regions']";
    private static final String REGION_OPTION_PATH = "//div[@class='popups']//span[@class='list-details']";
    private static final String TRAVEL_DATES_INPUT = "//div[@class='inputs travel-dates']//div[@class='icon cursor-pointer']";
    private static final String CALENDAR_DAY_BUTTON_PATH = "//div[@class='calendar-container desktop']//section[2]//button[contains(text(),'%s')]";

    public void waitUntilPageLoaded() {
        $x("//span[@id='page-one-travel']//main[@class='page-one-travel page-one-travel-insurance']")
                .shouldBe(visible);
    }

    @Step("Get Travel page title text")
    public String getTitleText() {
        waitUntilPageLoaded();

        return getText($x("//main[@class='page-one-travel page-one-travel-insurance']//h1[@class='title']"));
    }

    @Step("Get selected region text")
    public String getSelectedRegionText() {
        waitUntilPageLoaded();

        return getText($x(REGION_BUTTON_PATH+"//button//span[@class='text text-icon']"));
    }

    @Step("Region button click")
    public void regionButtonClick() {
        waitUntilPageLoaded();

        $x(REGION_BUTTON_PATH+"//button")
                .shouldBe(visible)
                .click();
    }

//region pop-up
    @Step("Click on region {value} in the pop-up")
    public void regionOptionButtonClick(String value) {
    waitUntilPageLoaded();

        SelenideElement element = $x(String.format(REGION_OPTION_PATH+"//button//span[normalize-space(text())='%s']", value));
        if (element.exists()) {
            element.scrollIntoView(true);
        }

        element.click();
    }

    @Step("Get count of regions offered by default")
    public int getDefaultRegionCount() {

        return $$x(REGION_OPTION_PATH+"//following-sibling::button").size();
    }
//endregion

    @Step("Click to select date")
    public void datesButtonClick() {
        waitUntilPageLoaded();

        $x(TRAVEL_DATES_INPUT)
                .shouldBe(visible)
                .click();
    }

//region calendar
    @Step("Select two travel dates {to} and {from}")
    public void selectTravelDates(String from, String to) {
        waitUntilPageLoaded();

        SelenideElement fromThisDate = $x(String.format(CALENDAR_DAY_BUTTON_PATH, from));
        fromThisDate.click();

        SelenideElement toThisDate = $x(String.format(CALENDAR_DAY_BUTTON_PATH, to));
        toThisDate.click();
    }
//endregion

    @Step("Click to receive offer")
    public void receiveOfferButtonClick() {
        $x("//span[@id='page-one-travel']//section[@class='form']//div[@class='buttons']//button")
                .shouldBe(visible)
                .shouldBe(enabled)
                .click();
    }
}
