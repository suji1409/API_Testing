package RequestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteBookRequest {
    @JsonProperty
    private String ID;

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }




    public DeleteBookRequest(String ID) {
        this.ID = ID;
    }
}
