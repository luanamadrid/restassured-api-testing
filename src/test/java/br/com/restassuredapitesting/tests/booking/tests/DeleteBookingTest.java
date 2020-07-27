package br.com.restassuredapitesting.tests.booking.tests;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.E2e;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.util.concurrent.TimeUnit;


@Feature("Reservas")
public class DeleteBookingTest extends BaseTest {
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Deletar uma reserva utilizando token")
    public void validarDeletarUmaReservaUtilizandoToken() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");
        deleteBookingRequest.deleteUmaReservaComToken(primeiroId).then()
                .statusCode(201)
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS);
              //  .body("OK",hasToString("Created"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(E2e.class)
    @DisplayName("Deletar uma reserva inexistente com token")
    public void validarUmaDeletarReservaInexistenteComToken() throws Exception{
        deleteBookingRequest.deleteUmaReservaInexistenteComToken().then()
                .statusCode(405)
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS);
               // .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(E2e.class)
    @DisplayName("Deletar uma reserva sem token")
    public void validarDeletarUmaReservaSemToken() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");
        deleteBookingRequest.deleteUmaReservaSemToken(primeiroId).then()
                .statusCode(403)
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS);
        //  .body("OK",hasToString("Created"));
    }

}
