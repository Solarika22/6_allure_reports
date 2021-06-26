import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    private static final String GITHUB_URL = "https://github.com";
    String REPOSITORY = "selenide/selenide";
    String ELEMENT_TEXT = "Issues";

    @Step("Открыть главную страницу Github")
    public void openMainPage() {
        open(GITHUB_URL);
    }
    @Step("Ввести значение в поле поиска и нажать Enter")
    public void SearchRepository (String repository) {
        $(".header-search-input").val(REPOSITORY).pressEnter();
    }
    @Step("Клик на раздел {repository}")
    public void ClickOnRepository (String repository) {
        $(By.linkText(REPOSITORY)).click();
    }
    @Step("Клик по вкладке Issue")
    public void ClickOnIssueTab () {
        $(".js-repo-nav").$(byText(ELEMENT_TEXT)).click();
    }
    @Step("Проверка Issue {number}")
    public void CheckIssueNumber(int number) {
        $("#issue_1486_link").should(Condition.exist);
    }
}
