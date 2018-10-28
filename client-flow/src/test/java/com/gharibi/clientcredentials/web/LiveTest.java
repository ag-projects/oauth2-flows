package com.gharibi.clientcredentials.web;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LiveTest {

    static String APP_ROOT = "http://localhost:8081/um-webapp";

    @Test
    public void whenObtainAccessToken_thenOk() throws Exception {
        Response response = RestAssured
                .given().auth().preemptive()
                .basic("lssClient", "lssSecret")
                .with().formParam("grant_type", "client_credentials")
                .post(APP_ROOT + "/oauth/token");

        assertEquals(200, response.getStatusCode());
        assertNotNull(response.jsonPath().getString("access_token"));
    }
}
