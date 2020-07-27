package br.com.restassuredapitesting.tests.booking.tests;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.greaterThan;


public class PostBookingTest extends BaseTest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Alterar uma reserva utilizando token")
    public void criaUmaReserva() throws Exception{
        postBookingRequest.criaUmaReserva(Utils.validPayloadBooking()).then()
                .statusCode(200)
                .time(Matchers.lessThan(3L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Validar retorno 500 quando o payload da reserva estiver inválido")
    public void error500CriaReserva() throws Exception{
        postBookingRequest.criaUmaReserva(Utils.invalidPayloadBooking()).then()
                .statusCode(500)
                .time(Matchers.lessThan(3L), TimeUnit.SECONDS);
              //  .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Criar uma reserva enviando mais parâmetros no payload da reserva")
    public void criaUmaReservaMaisPaarametros() throws Exception{
        postBookingRequest.criaUmaReserva(Utils.moreParametersPayloadBooking()).then()
                .statusCode(200)
                .time(Matchers.lessThan(3L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Validar retorno 418 quando o header Accept for invalido")
    public void AcceptInvalidoCriarUmaReserva() throws Exception{
        postBookingRequest.AcceptInvalidoCriarUmaReserva(Utils.validPayloadBooking()).then()
                .statusCode(418)
                .time(Matchers.lessThan(3L), TimeUnit.SECONDS);
    }

}
