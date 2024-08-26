package com.prashu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

public class PaymenentInformation {

    @Column(name ="cardholder_name")
    private String cardholderName;

    @Column(name="card_number")
    private  String cardNumber;

    @Column(name="expiration_date")
    private LocalDate exprirationDate;

    @Column(name="cvv")
    private String cvv;

    public PaymenentInformation() {
    }

    public PaymenentInformation(String cardholderName, String cardNumber, LocalDate exprirationDate, String cvv) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.exprirationDate = exprirationDate;
        this.cvv = cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExprirationDate() {
        return exprirationDate;
    }

    public void setExprirationDate(LocalDate exprirationDate) {
        this.exprirationDate = exprirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

}
