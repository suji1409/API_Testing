package RequestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBookByIDRequest {

    private String ID;

        public void setBookID(String ID) {

        this.ID = ID;
    }

    public String getBookID() {

        return ID;
    }



}
