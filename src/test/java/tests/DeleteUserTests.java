package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.UserApiSteps;

import static specs.ResponseSpec.responseSpecNoContent204;

public class DeleteUserTests extends TestBase {

    private final UserApiSteps userSteps = new UserApiSteps();

    @Test
    @Tag("simple_test")
    void successfulDeleteUserTest() {
        userSteps.deleteUser("4", apiKey, responseSpecNoContent204);
    }

    @Test
    @Tag("simple_test")
    void unsuccessfulDeleteUserTest() {
        userSteps.deleteUser("9999", apiKey, responseSpecNoContent204);
    }
}
