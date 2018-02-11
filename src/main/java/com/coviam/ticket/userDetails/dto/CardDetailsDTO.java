package com.coviam.ticket.userDetails.dto;

import java.io.Serializable;

/**
 * Created by avinashkumar on 05/02/2018 AD.
 */
public class CardDetailsDTO implements Serializable {

    private String id;
    private String cardNumber;
    private String nameOnCard;
    private String expDate;
    private UserDTO owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }


    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardDetailsDTO that = (CardDetailsDTO) o;

        if (!id.equals(that.id)) return false;
        if (!cardNumber.equals(that.cardNumber)) return false;
        if (!nameOnCard.equals(that.nameOnCard)) return false;
        if (!expDate.equals(that.expDate)) return false;
        return owner.equals(that.owner);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + cardNumber.hashCode();
        result = 31 * result + nameOnCard.hashCode();
        result = 31 * result + expDate.hashCode();
        result = 31 * result + owner.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CardDetailsDTO{" +
                "id='" + id + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", expDate='" + expDate + '\'' +
                ", owner=" + owner +
                '}';
    }
}
