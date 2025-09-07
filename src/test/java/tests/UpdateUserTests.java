package tests;

import models.User;
import models.UpdateUserResponse;
import org.junit.jupiter.api.Test;
import steps.UserApiSteps;

import static org.assertj.core.api.Assertions.assertThat;
import static specs.ResponseSpec.responseSpecOk200;

public class UpdateUserTests extends TestBase {

    private final UserApiSteps userSteps = new UserApiSteps();

    @Test
    void updateUserTest() {
        User user = User.builder()
                .name("Kaid Updated")
                .job("Senior QA")
                .build();

        UpdateUserResponse response = userSteps.updateUser("2", user, responseSpecOk200);

        assertThat(response.getName()).isEqualTo(user.getName());
        assertThat(response.getJob()).isEqualTo(user.getJob());
    }
}
