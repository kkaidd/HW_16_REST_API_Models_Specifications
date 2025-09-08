package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ResponseSpec {

    public static ResponseSpecification responseSpecOk200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5L), SECONDS)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification responseSpecCreated201 = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification responseSpecNoContent204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification responseSpecBadRequest400 = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.ALL)
            .build();

}
