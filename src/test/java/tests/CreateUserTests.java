package tests;

import models.User;
import models.CreateUserResponse;
import org.junit.jupiter.api.Test;
import steps.UserApiSteps;

import static org.assertj.core.api.Assertions.assertThat;
import static specs.ResponseSpec.responseSpecCreated201;

public class CreateUserTests extends TestBase {

    private final UserApiSteps userSteps = new UserApiSteps();

    @Test
    void createUserTest() {
        User user = User.builder()
                .name("Kaid")
                .job("QA Automation")
                .build();

        CreateUserResponse response = userSteps.createUser(user, responseSpecCreated201);

        assertThat(response.getName()).isEqualTo(user.getName());
        assertThat(response.getJob()).isEqualTo(user.getJob());
        assertThat(response.getId()).isNotNull();
    }
}
