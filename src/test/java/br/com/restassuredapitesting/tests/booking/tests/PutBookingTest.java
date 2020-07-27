package br.com.restassuredapitesting.tests.booking.tests;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.greaterThan;


@Feature("Reservas")
public class PutBookingTest extends BaseTest {
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PutBookingRequest putBookingRequest = new PutBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Alterar uma reserva utilizando token")
    public void validarAlterarUmaReservaUtilizandoToken() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");
       // System.out.println(primeiroId);
        putBookingRequest.alterarUmaReservaComToken(primeiroId, Utils.validPayloadBooking()).then()
                .statusCode(200)
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Alterar uma reserva usando o Basic auth")
    public void validarAlterarUmaReservaUtilizandoTokenBasicauth() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");
        // System.out.println(primeiroId);
        putBookingRequest.alterarUmaReservaComTokenBasicauth(primeiroId, Utils.validPayloadBooking()).then()
                .statusCode(200)
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Tentar alterar uma reserva quando o token não for enviado")
    public void validarAlterarUmaReservaSemToken() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");
        putBookingRequest.alterarUmaReservaSemToken(primeiroId, Utils.validPayloadBooking()).then()
                .statusCode(403)
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Tentar alterar uma reserva quando o token enviado for inválido")
    public void validarTentarUmaReservaUtilizandoTokenInvalido() throws Exception{
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");
        putBookingRequest.alterarUmaReservaComTokenInvalido(primeiroId, Utils.validPayloadBooking()).then()
                .statusCode(403)
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Tentar alterar uma reserva que não existe")
    public void validarTentarUmaReservaInexistente() throws Exception{
        putBookingRequest.alterarUmaReservaInexistente(Utils.validPayloadBooking()).then()
                .statusCode(405)
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS);
              //.body("size()",greaterThan(0));
    }

}
