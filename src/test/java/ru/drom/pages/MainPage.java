package ru.drom.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
            headerTitle = $("h2");

    private final ElementsCollection
            headerTabs = $$("[data-ftid='component_header_main-menu-item']");

    public MainPage checkPageOpen() {
        headerTitle.shouldHave(text("Продажа авто в России"));
        return this;
    }

    public MainPage clickOnTab(final String data) {
        headerTabs.find(text(data)).click();
        return this;
    }
}
