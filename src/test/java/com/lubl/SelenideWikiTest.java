package com.lubl;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideWikiTest {

    @Test
    void parseSoftAssertionsPage() {
        Selenide.open("https://github.com/selenide/selenide");//Открыть страницу Selenide в GitHub
        $("#wiki-tab").click();//Перейти в раздел Wiki
        Selenide.zoom(0.5);
        $("li.wiki-more-pages-link").$("button").click();//Открыть скрытые страницы
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));//Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();//Открыть страницу Soft Asserions
        $("#wiki-wrapper").shouldHave(text("JUnit5 extension"), text("Using JUnit5 extend test class"));//Проверить, что есть код для JUnit5
    }
}
