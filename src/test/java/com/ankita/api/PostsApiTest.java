package com.ankita.api;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsApiTest extends BaseTest {

    @Test(description = "GET a single post returns the correct post")
    public void getSinglePost() {
        given()
        .when()
            .get("/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", equalTo(1))
            .body("title", not(emptyOrNullString()));
    }

    @Test(description = "GET all posts returns 100 posts")
    public void getAllPosts() {
        given()
        .when()
            .get("/posts")
        .then()
            .statusCode(200)
            .body("size()", equalTo(100))
            .body("[0].id", equalTo(1));
    }

    @Test(description = "POST creates a new post and echoes it back")
    public void createPost() {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "CI/CD learning");
        body.put("body", "My first pipeline test");
        body.put("userId", 7);

        given()
            .body(body)
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("title", equalTo("CI/CD learning"))
            .body("userId", equalTo(7));
    }

    @Test(description = "PUT updates an existing post")
    public void updatePost() {
        Map<String, Object> body = new HashMap<>();
        body.put("id", 1);
        body.put("title", "Updated title");
        body.put("body", "Updated body");
        body.put("userId", 1);

        given()
            .body(body)
        .when()
            .put("/posts/1")
        .then()
            .statusCode(200)
            .body("title", equalTo("Updated title"));
    }

    @Test(description = "DELETE a post returns 200")
    public void deletePost() {
        given()
        .when()
            .delete("/posts/1")
        .then()
            .statusCode(200);
    }
}
