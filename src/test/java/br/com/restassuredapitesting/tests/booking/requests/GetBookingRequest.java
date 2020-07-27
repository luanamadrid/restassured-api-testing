package br.com.restassuredapitesting.tests.booking.requests;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetBookingRequest {
    @Step("Buscar todas as reservas.")
    public Response allBookings(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking");
    }


    @Step("Buscar uma reserva.")
    public Response listaUmaReserva(int id){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking/"+id);
    }

    @Step("Bucar uma reserva por firstname")
    public Response listaUmaReservaPorFirstname(){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking?firstname="+"Eric");
    }

    @Step("Bucar uma reserva por lastname")
    public Response listaUmaReservaPorLastname(){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking?lastname="+"Ericsson");
    }

     /*   @Step("Bucar uma reserva por lastname")
    public Response listaUmaReservaPorLastname(String lastname){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking?lastname="+lastname);
    }*/

    @Step("Bucar uma reserva por checkin")
    public Response listaUmaReservaPorCheckin(){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking?checkin="+"2016-10-22");
    }

    @Step("Bucar uma reserva por checkout")
    public Response listaUmaReservaPorCheckout(){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking?checkout="+"2018-11-25");
    }

    @Step("Bucar uma reserva por checkin e checkout")
    public Response listaUmaReservaPorCheckinCheckout(){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking?checkout="+"2020-03-13","&checkin="+"2020-05-23");
    }

    @Step("Bucar uma reserva por checkin, checkout e firstname")
    public Response listaUmaReservaPorFirstnameCheckinCheckout(){
        return given()
                .header("Accept", "application/json")
                .when()
                .get("booking?checkout="+"2020-03-13","&checkin="+"2020-05-23","&firstname"+"Eric");
    }




}
