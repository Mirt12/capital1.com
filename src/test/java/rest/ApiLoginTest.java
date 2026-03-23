package rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiLoginTest {

    @Test
    public void validUserCanLoginTest() {
        RestPageObjectForLogin po = new RestPageObjectForLogin();
        given().headers(po.getRequestHeaders())
                .queryParams(po.getQueryParams("tbalashevich@bk.ru", "PostinG@2579!", "0cAFcWeA7SoTfmBihAlsWW3QPuaDR1dUi6m9zHxAgs1CCxF06533Fvh7FyHDtHEbR7GcmG4KrBmXBE6VNN4c0nuRVQgA8dvbf8BJmfqvPuLF4jlufgZMMMKy_ekHJ90RC0qQ"))
                .when().post(po.endpointToken)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
