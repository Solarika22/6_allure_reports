import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TitleCheckIssue {

    @BeforeAll
    static void setUpConfig() {

        Configuration.startMaximized = true;
    }

    private static final String GITHUB_URL = "https://github.com";
                         String REPOSITORY = "selenide/selenide";
                         String ELEMENT_TEXT = "Issues";

    @Test
    public void SelenideCheckTitle () {
            //#1
            open(GITHUB_URL);
            //#2
            $(".header-search-input").val(REPOSITORY).pressEnter();
            //#3
            $(By.linkText(REPOSITORY)).click();
            //#4
            $(".js-repo-nav").$(byText(ELEMENT_TEXT)).click();
            //#5
            $("#issue_1486_link").should(Condition.exist);
    }

    @Test
    public void LambdaCheckTitle () {
        step("Открыть главную страницу Github", () -> {
            open(GITHUB_URL);
        });
        step("Ввести значение в поле поиска и нажать Enter", () -> {
            $(".header-search-input").val(REPOSITORY).pressEnter();
        });
       step("Клик на раздел {REPOSITORY}", () -> {
           $(By.linkText(REPOSITORY)).click();
       });
        step("Клик по вкладке Issue", () ->{
            $(".js-repo-nav").$(byText(ELEMENT_TEXT)).click();
        });

        step("Проверка Issue {number}", () -> {
            $("#issue_1486_link").should(Condition.exist);
        });

    }

    private WebSteps steps = new WebSteps();

    @Test
    public void AnnotationCheckTitle () {
        steps.openMainPage();
        steps.SearchRepository("selenide/selenide");
        steps.ClickOnRepository("selenide/selenide");
        steps.ClickOnIssueTab();
        steps.CheckIssueNumber(1486);
    }


}
