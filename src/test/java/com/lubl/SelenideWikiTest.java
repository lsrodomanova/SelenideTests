package com.lubl;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelenideWikiTest {

    @Test
    void parseSoftAssertionsPage() {
        Selenide.open("https://github.com/selenide/selenide");//Открыть страницу Selenide в GitHub
        $("#wiki-tab").click();//Перйти в раздел Wiki
        $(".markdown-body").shouldHave(text("Soft assertions"));//Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $(".markdown-body").$(byText("Soft assertions")).click();//Открыть страницу Soft Asserions
        $("#wiki-wrapper").shouldHave(text("JUnit5 extension"), text("Using JUnit5 extend test class"));//Проверить, что есть код для JUnit5
    }
}
