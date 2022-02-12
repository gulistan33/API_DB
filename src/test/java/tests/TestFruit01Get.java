package tests;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.FruitTestBase;

import java.util.*;

import static io.restassured.RestAssured.*;

public class TestFruit01Get extends FruitTestBase {

    @Test
    public void testGet() {
        JsonPath jp = given().accept("application/json").
                when().get("/categories/").
                then().statusCode(200).
                contentType("application/json").
                log().body().extract().jsonPath();


        List<String> nameList = jp.getList("categories.name");
        Assert.assertEquals(nameList.get(0), "Fruits");
        Assert.assertEquals(nameList.get(nameList.size() - 3), "Nuts");

    }

    @Test
    public void testOneGet() {
        Response response = given().log().uri()
                .contentType(ContentType.JSON)
                .pathParams("id", "Fruits")
                .when()
                .get("/categories/{id}");

        Assert.assertEquals(response.statusCode(), 200);
        //Assertions.assertTrue(ContentType.JSON.toString().startsWith(response.contentType()) );
        System.out.println(response.contentType());
        // System.out.println(response.body().prettyPrint());
        JsonPath js = response.jsonPath();

        Map<String, String> firstProduct = js.get("products[0]");
        System.out.println(firstProduct);
        Assert.assertEquals(firstProduct.get("name"), "Oranges");

        List<Map.Entry> listMap = new ArrayList<>(firstProduct.entrySet());

        Assert.assertEquals(listMap.get(1).getKey(), "product_url");
        System.out.println(listMap);

        // List<Map<String, String>> listOfMap = js.getList("products");
        Assert.assertEquals(listMap.get(0).getValue(), "Oranges");
    }


}
