package Tests;

import RequestModel.AddBookRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddNewBookTest extends BaseTest {
    @Test
    public String addBook(AddBookRequest addBookreq,int StatusCode) {
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .body(addBookreq)
                .when()
                .post("/Library/Addbook.php")
                .then().statusCode(StatusCode).extract().response();
        System.out.println(response.asString());
        JsonPath jsonNode  = response.jsonPath();
        if(StatusCode==200){
            String ID = jsonNode.get("ID");
            String Msg = jsonNode.get("Msg");
            Assert.assertEquals(Msg,"successfully added");
            Assert.assertEquals(ID,addBookreq.getIsbn()+addBookreq.getAisle());
            return ID;
        }
        else {
            String ErrMsg = jsonNode.get("msg");
            return ErrMsg;
        }

    }
    @Test
    public void addBook() {
        AddBookRequest addBookreq = new AddBookRequest("235","author67","102","name89");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(addBookreq)
                .when()
                .post("/Library/Addbook.php")
                .then().statusCode(200).extract().response();
        System.out.println(response.asString());
        JsonPath jsonNode  = response.jsonPath();
        String ID = jsonNode.get("ID");
        String Msg = jsonNode.get("Msg");
        Assert.assertEquals(Msg,"successfully added");

        Assert.assertEquals(ID,addBookreq.getIsbn()+addBookreq.getAisle());
        System.out.println(ID);
    }
}
