package br.com.ada.livraria.MS_Users;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TesteApp {

    int createdId;
    @Test
    public void testCreateUser(){
        createdId =
        given()
                .contentType("application/json")
                .body("{\n" +
                        "    \"nickname\": \"Johnny\",\n" +
                        "    \"type\" : \"Admin\",\n" +
                        "    \"name\": \"Joao das neves\",\n" +
                        "    \"password\" : \"123\"\n" +
                        "}")
        .when()
                .post("http://localhost:8080/users")
        .then()
                .statusCode(201)
                .log().all()
                .extract()
                .path("id");
    }

    @Test
    public void testReadUser(){
        given()
        .when()
                .get("http://localhost:8080/users")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testDeleteUser(){
        testCreateUser();
        given()
                .contentType("application/json")
                .pathParam("id", createdId)
        .when()
                .delete("http://localhost:8080/users/{id}")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testUpdateUser(){
        testCreateUser();

        given()
                .contentType("application/json")
                .body("{\n" +
                        "    \"nickname\": \"Johnny2\",\n" +
                        "    \"type\" : \"Admin2\",\n" +
                        "    \"name\": \"Joao das neves2\",\n" +
                        "    \"password\" : \"1232\"\n" +
                        "}")
                .pathParam("id", createdId)
        .when()
                .put("http://localhost:8080/users/{id}")
        .then()
                .statusCode(204)
                .log();
    }
}


