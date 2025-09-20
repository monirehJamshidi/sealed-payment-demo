package com.example.demo.model;

public sealed interface Payment permits
        CreditCardPayment,PayPalPayment,CryptoPayment {
}
