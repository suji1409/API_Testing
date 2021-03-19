package EndToEndScenarios;

import RequestModel.AddBookRequest;
import Tests.AddNewBookTest;
import Tests.BaseTest;
import Tests.GetBookByIDTest;
import org.testng.annotations.Test;

public class VerifyDuplicateBookAddition extends BaseTest {

    @Test
    public void verifyDuplicateAddition() {
        AddNewBookTest addBook1 = new AddNewBookTest();
        GetBookByIDTest getBook1 = new GetBookByIDTest();
        AddBookRequest bookRequest1 = new AddBookRequest("15", "author67", "1562", "name89");
        String book1ID = addBook1.addBook(bookRequest1, 200);
        Boolean book1Status = getBook1.getBook(book1ID, "name89",200);
        System.out.println("Added Book 1 Successfully : " + book1Status);


        AddBookRequest bookRequest2 = new AddBookRequest("15", "author67", "1562", "name89");
        String Err = addBook1.addBook(bookRequest1, 404);
        System.out.println(Err.equalsIgnoreCase("Add Book operation failed, looks like the book already exists"));

    }

}
