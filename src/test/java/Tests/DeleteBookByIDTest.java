package Tests;

import RequestModel.AddBookRequest;
import RequestModel.DeleteBookRequest;
import ResponseModel.DeleteBookResponse;
import ResponseModel.GetBookByIDResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookByIDTest extends BaseTest{

    @Test()
    public void DeleteBook(){
        DeleteBookRequest DeleteBookReq = new DeleteBookRequest("90896");

        Response response = given().log().all()
                .header("Content-Type","application/json")
                .body(DeleteBookReq)
                .when()
                .post("/Library/DeleteBook.php")
                .then().statusCode(200).extract().response();

        String msg = response.jsonPath().get("msg").toString();
        Assert.assertEquals(msg,"book is successfully deleted");

    }

    @Test()
    public Boolean DeleteBook(String ID,int StatusCode){

        DeleteBookRequest DeleteBookReq = new DeleteBookRequest(ID);
        Response response = given().log().all()
                .header("Content-Type","application/json")
                .body(DeleteBookReq)
                .when()
                .post("/Library/DeleteBook.php")
                .then().statusCode(StatusCode).extract().response();

        String Actualmsg = response.jsonPath().get("msg").toString();

        if(StatusCode==200){
            Assert.assertEquals(Actualmsg,"book is successfully deleted");
            return true;
        }
        else{
            Assert.assertEquals(Actualmsg,"Delete Book operation failed, looks like the book doesnt exists");
            return false;
        }

    }
}
