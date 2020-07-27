package br.com.restassuredapitesting.tests.booking.requests;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequests;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {
    PostAuthRequests postAuthRequests = new PostAuthRequests();

    @Step("Deleta uma reserva com token")
    public Response deleteUmaReservaComToken(int id){
        return given()
                .header("Content-Type","application/json")
                .header("Cookie",postAuthRequests.getToken())
                .when()
                .delete("booking/"+id);

    }

    @Step("Deletar uma reserva inexistente com token")
    public Response deleteUmaReservaInexistenteComToken(){
        return given()
                .header("Content-Type","application/json")
                .header("Cookie",postAuthRequests.getToken())
                .when()
                .delete("booking/"+2312312);

    }

    @Step("Deletar uma reserva sem token")
    public Response deleteUmaReservaSemToken(int id){
        return given()
                .header("Content-Type","application/json")
                .when()
                .delete("booking/"+id);

    }

}
