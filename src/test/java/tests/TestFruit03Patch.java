package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import pojo.CostumerPojo;
import utilities.API_Util;
import utilities.FruitTestBase;


import static io.restassured.RestAssured.*;

public class TestFruit03Patch extends FruitTestBase {

    @Test
    public void patchUser() {
//        Map<String, String> patchMap = new LinkedHashMap<>();
//        patchMap.put("firstname","Fred");
//        //patchMap.put("lastname", "Meyers");
        int lastID = API_Util.validID();

        CostumerPojo patchFruits = new CostumerPojo();
        patchFruits.setFirstName("guli");
        patchFruits.setLastName("june");

        given().contentType("application/json").
                accept("application/json").
                pathParam("id", lastID).
                body(patchFruits).
                when().patch("customers/{id}").
                then().statusCode(200)
                .body("firstname",is(patchFruits.getFirstName()),
                "lastname",equalTo(patchFruits.getLastName()));
        ;
//
//         given().log().uri().
//                accept(ContentType.JSON).
//                pathParams("id",lastID).
//        when().get("customers/{id}").
//        then().log().body().statusCode(200).
//        body("firstname",is(patchFruits.getFirstName()),
//                "lastname",equalTo(patchFruits.getLastName()));



    }
}
