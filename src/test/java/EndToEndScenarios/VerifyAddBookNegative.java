package EndToEndScenarios;

import RequestModel.AddBookRequest;
import Tests.AddNewBookTest;
import Tests.BaseTest;
import Tests.GetBookByIDTest;
import org.testng.annotations.Test;

@Test
public class VerifyAddBookNegative extends BaseTest {

    public void VerifyAddBook() {
        AddNewBookTest addBook1 = new AddNewBookTest();
        GetBookByIDTest getBook1 = new GetBookByIDTest();
        AddBookRequest bookRequest1 = new AddBookRequest("1578", "author67", "1562", "name89");
        String Err = addBook1.addBook(bookRequest1, 404);
        System.out.println(Err.equalsIgnoreCase("Add Book operation failed, looks like the book already exists"));

    }

}
