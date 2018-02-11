package com.coviam.ticket.userDetails.dto.response;

import java.util.Date;
import java.util.StringJoiner;

public class UserDTOResponse {

    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String emailId;
    private String phoneNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("id = " + id)
                .add("dateOfBirth = " + dateOfBirth)
                .add("emailId = " + emailId)
                .add("firstName = " + firstName)
                .add("lastName = " + lastName)
                .add("phoneNumber = " + phoneNumber)
                .toString();
    }
}
