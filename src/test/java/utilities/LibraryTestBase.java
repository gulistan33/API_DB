package utilities;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;

public class LibraryTestBase {

    @BeforeTest
    public static void setup() {

        baseURI = "https://library2.cybertekschool.com/";
        basePath = "/rest/v1";
        // create the db connection here
        // createLibraryDBConnection() ;
//        String url = ConfigReader.read("library2.database.url");
//        String username = ConfigReader.read("library2.database.username");
//        String password = ConfigReader.read("library2.database.password");
//        DB_Util.createConnection(url, username, password);

    }

    /**
     * A handy method to create library db connection by reading properties file
     */
    public static void createLibraryDBConnection() {

        String url = ConfigReader.read("library2.database.url");
        String username = ConfigReader.read("library2.database.username");
        String password = ConfigReader.read("library2.database.password");
        DB_Util.createConnection(url, username, password);

    }

    @AfterTest
    public static void tearDown() {
        reset();
        // destroy the db connection here
        DB_Util.destroy();
    }


}
