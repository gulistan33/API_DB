package tests;


import org.testng.annotations.Test;
import pojo.CostumerPojo;
import utilities.API_Util;
import utilities.FruitTestBase;

import static io.restassured.RestAssured.*;

public class TestFruit02Post extends FruitTestBase {

    @Test
    public void postRequest() {
        CostumerPojo fruits = new CostumerPojo("Gulistan", "abdu");

        given().accept("application/json").
                contentType("application/json").
                body(API_Util.randomCustomerCreater()).
                when().post("customers/").
                then().statusCode(201).log().body();
    }


}
