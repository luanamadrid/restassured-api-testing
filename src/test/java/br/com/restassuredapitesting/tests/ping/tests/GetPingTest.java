package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.Healthcheck;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.ping.requests.GetPingRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThan;

public class GetPingTest extends BaseTest {

    GetPingRequest getPingRequest = new GetPingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Healthcheck.class)
    @DisplayName("Verificar se API HealthCheck está online")

    public void verificaApiOnline() throws Exception{
        getPingRequest.ping().then()
                .statusCode(201)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS);
               // .body("size()",greaterThan(0));

    }

}
