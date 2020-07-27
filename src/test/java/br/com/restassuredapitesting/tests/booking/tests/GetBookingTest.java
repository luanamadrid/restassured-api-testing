package br.com.restassuredapitesting.tests.booking.tests;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.Contract;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.io.File;
import java.util.concurrent.TimeUnit;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Reservas")
public class GetBookingTest extends BaseTest {
    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar ID's das Reservas")
    public void validarIdsDasReservas() throws Exception{
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno da lista de reservas")
    public void garantirContratoListaReserva() throws Exception{
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .assertThat()
                .body(
                        matchesJsonSchema(
                            new File(
                                    Utils.getContractsBasePath("booking","bookings")
                            )
                        )
                );
    }



    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno de uma de reservas")
    public void garantirContratoUmaReserva() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");
        getBookingRequest.listaUmaReserva(primeiroId).then()
                .statusCode(200)
                .assertThat()
                .body(
                        matchesJsonSchema(
                                new File(
                                        Utils.getContractsBasePath("booking","bookingList")
                                )
                        )
                );
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva")
    public void validarUmaReserva() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");
        getBookingRequest.listaUmaReserva(primeiroId).then()
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS);
        //   .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por nome")
    public void valicarUmaReservaPorNome() throws Exception{
        getBookingRequest.listaUmaReservaPorFirstname().then()
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));

    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Sobrenome")
    public void valicarUmaReservaPorSobrenome() throws Exception{
        getBookingRequest.listaUmaReservaPorLastname().then()
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

 /*   @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Sobrenome")
    public void valicarUmaReservaPorSobrenome() throws Exception{
        String primeiroLastname = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].lastname");
        getBookingRequest.listaUmaReservaPorLastname(primeiroLastname)
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }*/

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por checkin")
    public void valicarUmaReservaPorCheckin() throws Exception{
        getBookingRequest.listaUmaReservaPorCheckin().then()
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por checkout")
    public void valicarUmaReservaPorCheckout() throws Exception{
        getBookingRequest.listaUmaReservaPorCheckout().then()
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por checkin e checkout")
    public void verificarUmaReservaPorCheckinCheckout() throws Exception{
        getBookingRequest.listaUmaReservaPorCheckinCheckout().then()
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por checkin, checkout e firstname")
    public void verificarUmaReservaPorFirstnameCheckinCheckout() throws Exception{
        getBookingRequest.listaUmaReservaPorFirstnameCheckinCheckout().then()
                .statusCode(200)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

}
