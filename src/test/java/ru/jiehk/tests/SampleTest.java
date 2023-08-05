package ru.jiehk.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SampleTest extends TestBase {
    public static final String TEXT = "hello@browserstack.com";

    @Test
    @Tag("ios")
    void sampleTest() {
        step("Переход на форму ввода текста", () ->
                $(AppiumBy.accessibilityId("Text Button")).click());
        step("Ввод текста", () ->
                $(AppiumBy.accessibilityId("Text Input")).sendKeys(TEXT + "\n"));
        step("Проверка введенного ранее текста", () ->
                $(AppiumBy.accessibilityId("Text Output")).shouldHave(text(TEXT)));
    }
}
