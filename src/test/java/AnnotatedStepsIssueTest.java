import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class AnnotatedStepsIssueTest {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/qasambakir/ALLURE-REPORTS-AUTOTESTS/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void testIssueTitleWithAnnotatedSteps() {
        openMainPage();
        clickOnRepositoryLink("ALLURE-REPORTS-AUTOTESTS");
        openIssuesTab();
        shouldSeeIssueWithTitle("Check Allure Reports Results");
    }

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/qasambakir/ALLURE-REPORTS-AUTOTESTS/");
    }

    @Step("Кликаем на репозиторий {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с названием {issue}")
    public void shouldSeeIssueWithTitle(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
}
