package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ResponseSpec {

    public static ResponseSpecification createResponseSpec(int statusCode) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(LogDetail.ALL);

        if (statusCode >= 200 && statusCode < 300) {
            builder.expectResponseTime(lessThan(5L), SECONDS);
        }

        return builder.build();
    }

    public static ResponseSpecification responseSpecOk200 = createResponseSpec(200);
    public static ResponseSpecification responseSpecCreated201 = createResponseSpec(201);
    public static ResponseSpecification responseSpecNoContent204 = createResponseSpec(204);
    public static ResponseSpecification responseSpecBadRequest400 = createResponseSpec(400);
}