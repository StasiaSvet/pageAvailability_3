import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void softAssertionsPage () {
        //---Open Selenide page on Github

       open("https://github.com/");
       $(byName("q")).setValue("Selenide").pressEnter();
       $(".repo-list").shouldHave(text("Selenide"));
       $(byLinkText("selenide/selenide")).click();

        //---Go to Wiki
        //$(".UnderlineNav-body").find(byText("Wiki")).click();
        $(byText("Wiki")).click();


        //---SoftAssertions page is available in the list
        $(".markdown-body").shouldHave(text("Soft assertions"));

        //---Open SoftAssertions page
        $(".markdown-body").findElement(byText("Soft assertions")).click();
        $(".gh-header").shouldHave((text("SoftAssertions")));

        //---Check JUnit5 code
        $("#wiki-body").shouldHave(text("JUnit5 extension"));

    }
}
