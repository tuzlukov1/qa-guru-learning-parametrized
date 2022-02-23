package ru.drom.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.drom.pages.AbstractInnerPage;
import ru.drom.pages.MainPage;

import java.util.stream.Stream;

public class DromTests extends TestBase{

    MainPage mainPage = new MainPage();
    AbstractInnerPage abstractInnerPage = new AbstractInnerPage();

    @ValueSource(strings = {"Автомобили", "Грузовики и спецтехника"})
    @ParameterizedTest(name = "Проверка перехода по ссылкам из шапки")
    @DisplayName("Переход по элементу шапки '{0}'")
    void tabTransitionTestNoUrlCheck(String tabName) {
        mainPage.checkPageOpen()
                .clickOnTab(tabName);

        abstractInnerPage.checkNotMainPageOpened();
    }

    @CsvSource(value = {
            "Запчасти | https://baza.drom.ru/",
            "Отзывы | https://www.drom.ru/reviews/"
    },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Проверка перехода по ссылкам из шапки")
    @DisplayName("Переход по элементу шапки '{0} и проверка url '{1}'")
    void tabTransitionTestWithUrlCheckCsvSource(String tabName, String expectedUrl) {
        mainPage.checkPageOpen()
                .clickOnTab(tabName);

        abstractInnerPage.checkCorrectPageOpened(expectedUrl);
    }

    static Stream<Arguments> multipleArgumentsTestDataProvider() {
        return Stream.of(
                Arguments.of("Каталог", "https://www.drom.ru/catalog/"),
                Arguments.of("Шины", "https://baza.drom.ru/wheel/tire/")
        );
    }

    @MethodSource(value = "multipleArgumentsTestDataProvider")
    @ParameterizedTest(name = "Проверка перехода по ссылкам из шапки")
    @DisplayName("Переход по элементу шапки '{0} и проверка url '{1}'")
    void tabTransitionTestWithUrlCheckDataProvider(String tabName, String expectedUrl) {
        mainPage.checkPageOpen()
                .clickOnTab(tabName);

        abstractInnerPage.checkCorrectPageOpened(expectedUrl);
    }
}
