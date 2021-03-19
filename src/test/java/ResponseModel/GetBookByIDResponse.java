package ResponseModel;

public class GetBookByIDResponse {

    private String book_name;
    private String isbn;

    public String getBook_name() {
        return book_name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String aisle;
    private String author;

    public String getBookName() {
        return book_name;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAisle() {
        return aisle;
    }

    public String getAuthor() {
        return author;
    }


}
