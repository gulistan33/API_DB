package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.CostumerPojo;
import utilities.API_Util;
import utilities.FruitTestBase;

import static io.restassured.RestAssured.*;

public class TestFruit05Put extends FruitTestBase {

    @Test
    public void put(){
        int lastId = API_Util.validID();
        CostumerPojo person = API_Util.randomCustomerCreater();

        given().log().uri()
                .contentType(ContentType.JSON)
                .body(person)
                .pathParam("id", lastId).
        when().put("customers/{id}").
                then().log().body().statusCode(200);


        JsonPath js = given().log().uri()
                .accept(ContentType.JSON)
                .pathParam("id", lastId).
                when().get("/customers/{id}").
                then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().jsonPath();

        Assert.assertEquals(person.getFirstName(),js.get("firstname"));
        Assert.assertEquals(person.getLastName(),js.get("lastname"));



    }
}
