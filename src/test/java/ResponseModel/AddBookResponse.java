package ResponseModel;

public class AddBookResponse {

    private String Msg;
    private String ID;



    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public void setID(String ID) {

        this.ID = ID;
    }


    public String getMsg() {

        return Msg;
    }

    public String getID() {

        return ID;
    }

    public String toString() {
        return "Books " + this.Msg + " has an ID of: " + this.ID;
    }



}
