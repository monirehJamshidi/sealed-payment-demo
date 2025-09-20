package com.example.demo.model;

public final class CryptoPayment implements Payment {
    private String walletId;
    private double amount;

    public CryptoPayment(String walletId, double amount){
        this.walletId = walletId;
        this.amount = amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public double getAmount() {
        return amount;
    }
}
