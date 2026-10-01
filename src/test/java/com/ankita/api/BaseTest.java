package com.ankita.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        // Can be overridden later from CI: mvn test -DbaseUrl=https://...
        RestAssured.baseURI = System.getProperty("baseUrl", "https://jsonplaceholder.typicode.com");
        RestAssured.requestSpecification = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
        // Prints request/response details only when a test fails
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
