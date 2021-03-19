package RequestModel;

import java.util.ArrayList;

public class AddBookRequest {

    private String aisle;
    private String author;
    private String isbn;
    private String name;

    public AddBookRequest(String aisle, String author, String isbn, String name) {
        this.aisle = aisle;
        this.author = author;
        this.isbn = isbn;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getAisle() {
        return aisle;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setBook_Name(String name) {
        this.name = name;
    }

    public void setBook_Author(String author) {
        this.author = author;
    }

    public void setBook_ISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setBook_Aisle(String aisle) {
        this.aisle = aisle;
    }

}
