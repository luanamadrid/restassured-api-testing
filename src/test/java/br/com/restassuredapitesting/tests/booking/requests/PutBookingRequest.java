package br.com.restassuredapitesting.tests.booking.requests;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequests;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class PutBookingRequest {

    PostAuthRequests postAuthRequests = new PostAuthRequests();

    @Step("Alterar uma reserva com token")
    public Response alterarUmaReservaComToken(int id, JSONObject payload){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie",postAuthRequests.getToken())
                .when()
                .body(payload.toString())
                .put("booking/"+id);
    }

    @Step("Alterar uma reserva com token e Basic auth")
    public Response alterarUmaReservaComTokenBasicauth(int id, JSONObject payload){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie",postAuthRequests.getToken())
                .header("Authorisation",postAuthRequests.getToken())
                .when()
                .body(payload.toString())
                .put("booking/"+id);
    }

    @Step("Alterar uma reserva sem token")
    public Response alterarUmaReservaSemToken(int id, JSONObject payload){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .when()
                .body(payload.toString())
                .put("booking/"+id);
    }

    @Step("Alterar uma reserva com token Inválido")
    public Response alterarUmaReservaComTokenInvalido(int id, JSONObject payload){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie","tokenInvalido")
                .when()
                .body(payload.toString())
                .put("booking/"+id);
    }

    @Step("Alterar uma reserva inexistente")
    public Response alterarUmaReservaInexistente(JSONObject payload){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie",postAuthRequests.getToken())
                .when()
                .body(payload.toString())
                .put("booking/"+453454353);
    }

}
