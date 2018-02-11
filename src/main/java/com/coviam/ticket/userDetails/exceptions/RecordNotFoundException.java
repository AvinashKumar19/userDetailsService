package com.coviam.ticket.userDetails.exceptions;

public class RecordNotFoundException extends RuntimeException {

    private String userId;

    public RecordNotFoundException(String userId) {
        super("Record with id : " + userId + " does not exist in database.");
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
