import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubIssueTest {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://github.com/qasambakir/ALLURE-REPORTS-AUTOTESTS/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    @DisplayName("Успешная проверка 'Issue' с Listener")
    void successCheckForIssuesTest() {
        open("https://github.com/qasambakir/ALLURE-REPORTS-AUTOTESTS/");

        $("#issues-tab").click();

        $(withText("Check Allure Reports Results")).should(Condition.exist);
    }

}
