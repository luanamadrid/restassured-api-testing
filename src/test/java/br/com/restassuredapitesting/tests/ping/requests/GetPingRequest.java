package br.com.restassuredapitesting.tests.ping.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetPingRequest {
    @Step ("Verificar se API HealthCheck está online")
    public Response ping() {
        return given()
                .when()
                .get("ping");
    }
}
