package ru.jiehk.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class WikipediaTests extends TestBase {

    @Test
    @Tag("android")
    void successfulSearchTest() {
        step("Ввод поискового запроса", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверка наличиия результатов поиска", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("android")
    void errorPageTest() {
        step("Переход в статью с главной страницы", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_featured_article_card_article_title")).click();
        });
        step("Проверка экрана ошибки", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_text")).
                    shouldHave(text("An error occurred"));
            $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_button")).
                    shouldBe(visible);
        });
    }
}