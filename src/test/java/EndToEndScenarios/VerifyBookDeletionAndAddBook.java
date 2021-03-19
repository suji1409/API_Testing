package EndToEndScenarios;

import RequestModel.AddBookRequest;
import Tests.AddNewBookTest;
import Tests.BaseTest;
import Tests.DeleteBookByIDTest;
import Tests.GetBookByIDTest;
import org.testng.annotations.Test;

public class VerifyBookDeletionAndAddBook extends BaseTest {

    @Test
    public void verifyDeleteAndAddSameBook() {

        AddNewBookTest addBook1 = new AddNewBookTest();
        GetBookByIDTest getBook1 = new GetBookByIDTest();
        DeleteBookByIDTest deleteBook1 = new DeleteBookByIDTest();

        AddBookRequest bookRequest1 = new AddBookRequest("114", "author67", "36", "name89");
        String book1ID = addBook1.addBook(bookRequest1, 200);

        Boolean book1Status = getBook1.getBook(book1ID, "name89",200);
        System.out.println("Added and retrieved Book 1 Successfully : " + book1Status);

        Boolean bookDelete = deleteBook1.DeleteBook(book1ID,200);
        System.out.println("Deleted Book 1 Successfully : " + bookDelete);

        Boolean bookFound = getBook1.getBook(book1ID,"name89",404);
        System.out.println("Deleted Book cannot be found : " + bookFound);

        book1ID = addBook1.addBook(bookRequest1, 200);
        book1Status = getBook1.getBook(book1ID, "name89",200);
        System.out.println("Added Book 1 again Successfully  after Deletion : " + book1Status);

    }

}
