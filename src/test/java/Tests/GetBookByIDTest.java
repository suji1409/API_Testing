package Tests;

import ResponseModel.GetBookByIDResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetBookByIDTest extends BaseTest{

    @Test()
    public void getBook(){

        Response response = given().log().all()
                .queryParam("ID","102215")
                .when()
                .get("/Library/GetBook.php")
                .then().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.jsonPath().get("book_name").toString());

        GetBookByIDResponse[] bookByIDResponse = response.as(GetBookByIDResponse[].class);

       Assert.assertEquals(bookByIDResponse[0].getBookName(),"name89");

    }

    @Test()
    public Boolean getBook(String ID,String book_name,int StatusCode){

        Response response = given().log().all()
                .queryParam("ID",ID)
                .when()
                .get("/Library/GetBook.php")
                .then().statusCode(StatusCode).extract().response();

        GetBookByIDResponse[] bookByIDResponse = new GetBookByIDResponse[0];
        String Errormsg = null;

        if(StatusCode==200){
            bookByIDResponse = response.as(GetBookByIDResponse[].class);
        }
        if(StatusCode!=200){
            Errormsg = response.jsonPath().get("msg").toString();

        }

        if(StatusCode ==200 && (bookByIDResponse[0].getBookName().equalsIgnoreCase(book_name))) {
            return true;
        }
        if((StatusCode ==404) && Errormsg.contains("does not exists!")){
            return true;
        }
        else{
            return false;
        }

    }
}
