package com.onfido.qa.websdk.page;

import com.onfido.qa.webdriver.Driver;
import com.onfido.qa.websdk.util.ByUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountrySelector extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(CountrySelector.class);

    public static final By BASE = By.cssSelector("[data-onfido-qa=\"countrySelector\"]");
    public static final By SEARCH = By.cssSelector("[data-onfido-qa='countrySelector'] #country-search");
    public static final By SUBMIT_BUTTON = ByUtil.onfidoQa("countrySelectorNextStep");
    public static final By ERROR_MESSAGE = By.cssSelector(".onfido-sdk-ui-CountrySelector-fallbackText");

    public CountrySelector(Driver driver) {
        super(driver);
    }

    public CountrySelector select(String search) {
        searchFor(search);
        return selectFirstOptionInDropdownMenu();
    }

    public <T> T select(String search, Class<T> next) {
        select(search);
        return submit(next);
    }

    public <T> T submit(Class<T> next) {
        click(SUBMIT_BUTTON);
        return createComponent(next);
    }

    public CountrySelector searchFor(String search) {
        input(SEARCH, search);
        return this;
    }

    public CountrySelector selectFirstOptionInDropdownMenu() {
        sleep(250);
        driver.findElement(SEARCH).sendKeys(Keys.DOWN, Keys.ENTER);

        return this;
    }

    public boolean isSubmitBtnEnabled() {
        return driver.findElement(SUBMIT_BUTTON).isEnabled();
    }

    public boolean countryNotFoundMessageIdDisabled() {

        try {
            driver.waitFor(1).visibility(ERROR_MESSAGE);
        } catch (Exception e) {
            log.error("Waiting for error message", e);
        }

        return driver.isInDom(ERROR_MESSAGE) && driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    @Override
    protected By pageId() {
        // TODO: add pageId
        return BASE;
    }

    public WebElement countryFinderInput() {
        return driver.findElement(BASE, By.cssSelector("#country-search"));
    }

    public String selectorLabel() {
        return text(By.cssSelector(".onfido-sdk-ui-CountrySelector-label"));
    }
}
