package utilities;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojo.CostumerPojo;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class API_Util {

    public static int validID() {
        int oneId = 0;
        JsonPath js = given().log().uri().
                contentType(ContentType.JSON)
                .when().get(ConfigReader.read("FruitURL") + "shop/customers/")
                .then()
                .extract().jsonPath();


        List<Map<String, String>> allCusotmers = js.getList("customers");
        oneId = Integer.valueOf(allCusotmers.get(allCusotmers.size() - 1)
                .get("customer_url").substring(16));

        System.out.println(oneId);

        return oneId;

    }

    public static CostumerPojo randomCustomerCreater(){
        Faker faker = new Faker();
        CostumerPojo fruits = new CostumerPojo(faker.name().firstName(),faker.name().lastName());

        return fruits;


    }


}
