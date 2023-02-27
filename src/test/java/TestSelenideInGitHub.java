import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSelenideInGitHub {

    @Test
    void FullTestWiki() {

//Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

//Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

//Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("li.wiki-more-pages-link").$("[type=button]").click();

//Откройте страницу SoftAssertions
        $(byText("SoftAssertions")).click();

// проверьте что внутри есть пример кода для JUnit5
        $("#wiki-wrapper")
                .shouldHave(text("Using JUnit5 extend test class:\n" +
                        "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }
}
