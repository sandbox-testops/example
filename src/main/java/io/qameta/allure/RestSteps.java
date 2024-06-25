package io.qameta.allure;

import io.qameta.allure.Step;

import static io.qameta.allure.Allure.step;

public class RestSteps {

    @Step("Создать задачу с именем `{title}`")
    public void createIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("POST /repos/%s/%s/issues", owner, repo));
    }

    @Step("Закрыть задачу с именем `{title}`")
    public void closeIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("GET /repos/%s/%s/issues?text=%s", owner, repo, title));
        step(String.format("PATCH /repos/%s/%s/issues/%s", owner, repo, 10));
    }

    @Step("Проверить что запись содержащая `{title}` существует")
    public void shouldSeeIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("GET /repos/%s/%s/issues?text=%s", owner, repo, title));
        step(String.format("GET /repos/%s/%s/issues/%s", owner, repo, 10));
    }

}
