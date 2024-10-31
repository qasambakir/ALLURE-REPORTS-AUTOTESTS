import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class LambdaStepsIssueTest {

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://github.com/qasambakir/ALLURE-REPORTS-AUTOTESTS/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    @DisplayName("Успешная проверка 'Issue' через Step")
    void testIssueTitleWithLambdaSteps() {
        step("Открываем страницу репозитория", () -> {
            open("https://github.com/qasambakir/ALLURE-REPORTS-AUTOTESTS/");
        });

        step("Переходим в таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue с названием 'Check Allure Reports Results'", () -> {
            $(withText("Check Allure Reports Results")).should(Condition.exist);
        });
    }
}
