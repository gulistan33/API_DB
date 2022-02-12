package tests;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import utilities.API_Util;
import utilities.FruitTestBase;

import static io.restassured.RestAssured.*;

public class TestFruit04Delete extends FruitTestBase {

    @Test
    public void delete() {

        int id = API_Util.validID();

        JsonPath jsonPath = given().log().uri()
                .accept("application/json")
                .pathParam("id", id).
                when().delete("/customers/{id}")
                .then().log().body()
                .statusCode(200).extract().jsonPath();

        given().log().uri()
                .accept("application/json")
                .pathParam("id",id).
        when().get("/customers/{id}")
                .then().log().body()
                .statusCode(404);


    }
}
