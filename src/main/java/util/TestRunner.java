package util;

import com.pageobject.LoginPage;
import com.pageobject.MainPage;
import com.pageobject.PolicyPage;
import com.pageobject.TravelPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static util.ConfigHelper.getBrowser;
import static util.ConfigHelper.getPageElementLoadTimeoutMills;

public class TestRunner {

    protected MainPage mainPage = new MainPage();
    protected TravelPage travelPage = new TravelPage();
    protected PolicyPage policyPage = new PolicyPage();
    protected LoginPage loginPage = new LoginPage();


    @BeforeAll
    static void beforeAll() {
        System.setProperty("chromeoptions.args",
                "--disable-browser-side-navigation," +
                        "--disable-gpu,"+
                        "--dns-prefetch-disable," +
                        "--disable-impl-side-painting," +
                        "--disable-site-isolation-trials," +
                        "--no-sandbox," +
                        "--disable-infobars," +
                        "--ignore-certificate-errors," +
                        "--disable-popup-blocking," +
                        "--disable-notifications," +
                        "--disable-dev-shm-usage");

        com.codeborne.selenide.Configuration.browser = getBrowser();
        com.codeborne.selenide.Configuration.timeout = getPageElementLoadTimeoutMills();
        com.codeborne.selenide.Configuration.savePageSource = false;
        com.codeborne.selenide.Configuration.screenshots = true;
        com.codeborne.selenide.Configuration.startMaximized = true;

    }

    @AfterAll
    public static void finish() {
        closeWebDriver();
    }
}
