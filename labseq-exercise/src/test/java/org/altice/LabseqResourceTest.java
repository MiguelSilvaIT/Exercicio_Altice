package org.altice;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class LabseqResourceTest {

    @Test
    public void testLabseqEndpointValidValues() {
        given()
                .when().get("/labseq/4")
                .then()
                .statusCode(200)
                .body(is("1"));  // l(4) deve retornar 1


    }

    @Test
    public void testLabseqEndpointLargeValue() {
        given()
                .when().get("/labseq/10000")
                .then()
                .statusCode(200);
    }

    @Test
    public void testLabseqEndpointInvalidNegative() {
        given()
                .when().get("/labseq/-1")
                .then()
                .statusCode(400)
                .body(containsString("O índice deve ser um número inteiro não negativo."));  // Verifica a mensagem de erro
    }

    @Test
    public void testLabseqEndpointInvalidDecimal() {
        given()
                .when().get("/labseq/3.5")
                .then()
                .statusCode(400)
                .body(containsString("O índice deve ser um número inteiro não negativo."));  // Verifica a mensagem de erro
    }

    @Test
    public void testLabseqEndpointNonNumeric() {
        given()
                .when().get("/labseq/abc")
                .then()
                .statusCode(400)
                .body(containsString("O índice deve ser um número inteiro não negativo."));  // Verifica a mensagem de erro
    }
}
