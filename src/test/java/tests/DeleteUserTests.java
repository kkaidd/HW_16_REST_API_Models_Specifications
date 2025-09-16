package tests;

import org.junit.jupiter.api.Test;
import steps.UserApiSteps;

import static specs.ResponseSpec.responseSpecNoContent204;

public class DeleteUserTests extends TestBase {

    private final UserApiSteps userSteps = new UserApiSteps();

    @Test
    void successfulDeleteUserTest() {
        userSteps.deleteUser("4", responseSpecNoContent204);
    }

    @Test
    void unsuccessfulDeleteUserTest() {
        userSteps.deleteUser("9999", responseSpecNoContent204);
    }
}
