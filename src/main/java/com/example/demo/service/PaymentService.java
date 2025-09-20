package com.example.demo.service;

import com.example.demo.model.CreditCardPayment;
import com.example.demo.model.CryptoPayment;
import com.example.demo.model.PayPalPayment;
import com.example.demo.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment(Payment payment){
        return switch (payment){
            case CreditCardPayment credit -> "Paid " + credit.getAmount() + " with Credit Card " + credit.getCardNumber();
            case PayPalPayment pal -> "Paid " + pal.getAmount() + " with PayPal (" + pal.getEmail() + ")";
            case CryptoPayment crypto -> "Paid " + crypto.getAmount() + " with Crypto wallet " + crypto.getWalletId();
        };
    }
}

//@Service
//public class PaymentService {
//
//    public String processPayment(Payment payment) {
//        return switch (payment) {
//            case CreditCardPayment c -> "Paid " + c.getAmount() + " with Credit Card " + c.getCardNumber();
//            case PayPalPayment p     -> "Paid " + p.getAmount() + " with PayPal (" + p.getEmail() + ")";
//            case CryptoPayment x     -> "Paid " + x.getAmount() + " with Crypto wallet " + x.getWalletId();
//        };
//    }
//}
