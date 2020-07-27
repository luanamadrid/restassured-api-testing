package br.com.restassuredapitesting.tests.booking.requests;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    @Step("Cria uma reserva")
    public Response criaUmaReserva(JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(payload.toString())
                .post("booking/");
    }

    @Step("Accept for invalido ao cria reserva")
    public Response AcceptInvalidoCriarUmaReserva(JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","AcceptInvalid")
                .when()
                .body(payload.toString())
                .post("booking/");
    }
}
