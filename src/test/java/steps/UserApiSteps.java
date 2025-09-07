package steps;

import io.qameta.allure.Step;
import io.restassured.specification.ResponseSpecification;
import models.*;

import static io.restassured.RestAssured.given;
import static specs.RequestSpec.request;

public class UserApiSteps {

    @Step("Создаём пользователя {user.name} с работой {user.job}")
    public CreateUserResponse createUser(User user, ResponseSpecification responseSpec) {
        return given()
                .spec(request)
                .body(user)
                .when()
                .post("/users")
                .then()
                .spec(responseSpec)
                .extract().as(CreateUserResponse.class);
    }

    @Step("Обновляем пользователя {id} на имя {user.name}")
    public UpdateUserResponse updateUser(String id, User user, ResponseSpecification responseSpec) {
        return given()
                .spec(request)
                .body(user)
                .when()
                .put("/users/" + id)
                .then()
                .spec(responseSpec)
                .extract().as(UpdateUserResponse.class);
    }

    @Step("Логинимся с email={login.email}")
    public LoginUserResponse login(LoginUserRequest login, ResponseSpecification responseSpec) {
        return given()
                .spec(request)
                .body(login)
                .when()
                .post("/login")
                .then()
                .spec(responseSpec)
                .extract().as(LoginUserResponse.class);
    }

    @Step("Удаляем пользователя с id={id}")
    public void deleteUser(String id, String apiKey, ResponseSpecification responseSpec) {
        given()
                .header("x-api-key", apiKey)
                .spec(request)
                .when()
                .delete("/users/" + id)
                .then()
                .spec(responseSpec);
    }
}
