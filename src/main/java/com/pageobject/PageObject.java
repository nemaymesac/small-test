package com.pageobject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static util.ConfigHelper.*;

public class PageObject {

    static {

        System.setProperty("chromeoptions.args",
                "--disable-browser-side-navigation," +
                        "--disable-gpu," +
                        "--dns-prefetch-disable," +
                        "--disable-impl-side-painting," +
                        "--disable-site-isolation-trials," +
                        "--no-sandbox," +
                        "--disable-infobars," +
                        "--ignore-certificate-errors," +
                        "--disable-popup-blocking," +
                        "--disable-notifications," +
                        "--disable-dev-shm-usage");

        Configuration.browser = getBrowser();
        Configuration.timeout = getPageElementLoadTimeoutMills();
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.startMaximized = true;
    }

    @Step("Refresh page")
    public void refresh() {
        getWebDriver().navigate().refresh();
    }

    @Step("Close browser")
    public void closeBrowser() {
        getWebDriver().quit();
    }

    public String getPageUrl() {
        return getWebDriver().getCurrentUrl();
    }

    @Step("Wait to load page.")
    public void waitBrowser() {
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
