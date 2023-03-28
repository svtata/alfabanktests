package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class NegativeApiTest {

    @DisplayName("Открытие несуществующей страницы")
    @Test
    void searchWrongPageTest() {
        given()
                .contentType(ContentType.HTML)
        .when()
                .get("https://podeli.ru/infa")
        .then()
                .log().status()
                .statusCode(404);
    }

}

