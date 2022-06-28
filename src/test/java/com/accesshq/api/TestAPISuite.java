package com.accesshq.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestAPISuite {

    @Test
    public void Verify_StatusCode_200() {
        given().
                header("auth-key", "5b37a04c-ca81-4180-b7be-63f36fdf71ad")
                .param("q", "Tascott")
                .param("state", "NSW")
                .when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json")
                .then().assertThat()
                .statusCode(200);
    }

    @Test
    public void Verify_Correct_Postcode() {
        given().
                header("auth-key", "5b37a04c-ca81-4180-b7be-63f36fdf71ad")
                .param("q", "Tascott")
                .param("state", "NSW")
                .when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json")
                .then().assertThat().body("localities.locality.postcode",equalTo(2250));
    }
}
