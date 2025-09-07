package tests;

import models.LoginUserRequest;
import models.LoginUserResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.UserApiSteps;

import static org.assertj.core.api.Assertions.assertThat;
import static specs.ResponseSpec.responseSpecOk200;

public class LoginUserTests extends TestBase {

    private final UserApiSteps userSteps = new UserApiSteps();

    @Test
    void loginSuccessfulTest() {
        LoginUserRequest request = LoginUserRequest.builder()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();

        LoginUserResponse response = userSteps.login(request, responseSpecOk200);

        assertThat(response.getToken()).isNotNull();
    }

    @Test
    @Tag("simple_test")
    void loginUnsuccessfulTest() {
        LoginUserRequest request = LoginUserRequest.builder()
                .email("peter@klaven")
                .build();

        LoginUserResponse response = userSteps.login(request, responseSpecOk200);

        assertThat(response.getError()).isEqualTo("Missing password");
    }
}
