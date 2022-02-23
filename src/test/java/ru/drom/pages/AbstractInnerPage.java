package ru.drom.pages;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class AbstractInnerPage {

    public AbstractInnerPage checkNotMainPageOpened() {
        webdriver().shouldNotHave(url("https://www.drom.ru/"));
        return this;
    }

    public AbstractInnerPage checkCorrectPageOpened(final String data) {
        webdriver().shouldHave(urlStartingWith(data));
        return this;
    }
}
