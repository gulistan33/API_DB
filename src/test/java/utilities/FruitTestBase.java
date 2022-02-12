package utilities;


import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public abstract class FruitTestBase {

    @BeforeMethod
    public static void getFruit() {
        baseURI = ConfigReader.read("FruitURL");
        basePath = "/shop";
    }


    @AfterMethod
    public static void tearDown() {
        reset();
    }
}
