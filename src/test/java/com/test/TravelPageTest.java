package com.test;

import com.pageobject.PageObject;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import util.TestRunner;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TravelPageTest extends TestRunner {
    PageObject pageObject = new PageObject();

    @Test
    @Order(1)
    @Step("Verify page title and default region")
    public void verifyTravelPageTitleTextAndDefaultRegion() {
        mainPage.navigate();
        mainPage.languageButtonClick("LV");
        mainPage.ribbonMenuButtonClick("Ceļojumi");

        assertThat(travelPage.getTitleText())
                .isNotEmpty()
                .isEqualTo("Ceļojumu apdrošināšana")
                .as("Traveling page title text should be 'Ceļojumu apdrošināšana'");

        assertThat(travelPage.getSelectedRegionText())
                .isEqualTo("Eiropa")
                .as("Europe should be selected by default");
    }

    @Test
    @Order(2)
    @Step("Verify user is able to select traveling insurance program")
    public void verifyUserCanSelectTravelingInsuranceProgramAndDefaultParams() {
        String selectReg = "Krievija";

        travelPage.regionButtonClick();
        assertThat(travelPage.getDefaultRegionCount())
                .isNotNull()
                .isEqualTo(5)
                .as("By default user is offered 5 regions");

        travelPage.regionOptionButtonClick(selectReg);
        assertThat(travelPage.getSelectedRegionText())
                .isEqualTo(selectReg)
                .as("Krievija should be selected now");

        travelPage.datesButtonClick();
        travelPage.selectTravelDates("15","20");
        travelPage.receiveOfferButtonClick();
        pageObject.waitBrowser();
    }

    @Test
    @Order(3)
    @Step("Verify user can select one of 3 insurance programs")
    public void verifyUserCanSelectTravelingPolicy() {
        assertThat(policyPage.getOfferedPolicyPlansCount())
                .isEqualTo(3)
                .as("User gets 3 offered policies");

        policyPage.clickToChosePolicy(2);
        policyPage.submitClick();
    }

    @Test
    @Order(4)
    @Step("Verify user has 6 options to sign in and 'sign in as guest' button")
    public void verifySomeSignInOptionsAreAvailable() {
        assertThat(loginPage.getUserSignInOptionCount())
                .isNotNull()
                .isEqualTo(6);

        loginPage.signInAsGuestButtonClick();
        pageObject.waitBrowser();
        assertThat(pageObject.getPageUrl())
                .contains("guest")
                .as("Page to log in as guest should be opened");
    }

}
