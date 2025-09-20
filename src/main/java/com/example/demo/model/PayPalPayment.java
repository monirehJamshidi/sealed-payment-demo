package com.example.demo.model;

public final class PayPalPayment implements Payment{
    private String email;
    private double amount;

    public PayPalPayment(String email, double amount){
        this.email = email;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public double getAmount() {
        return amount;
    }
}
