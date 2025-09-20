package com.example.demo.model;

public final class CreditCardPayment implements Payment{
    private String cardNumber;
    private double amount;

    public CreditCardPayment(String cardNumber, double amount){
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getAmount() {
        return amount;
    }
}
