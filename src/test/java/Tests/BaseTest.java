package Tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = "http://216.10.245.166";
    }
}
