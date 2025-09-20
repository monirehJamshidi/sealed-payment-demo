package com.example.demo.controller;

import com.example.demo.model.CreditCardPayment;
import com.example.demo.model.CryptoPayment;
import com.example.demo.model.PayPalPayment;
import com.example.demo.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @RequestMapping("/credit")
    public String payWithCreditCard(){
        return paymentService.processPayment(new CreditCardPayment("1234-5678-9999", 100));
    }

    @RequestMapping("/paypal")
    public String payWithPaypal(){
        return paymentService.processPayment(new PayPalPayment("user@example.com", 200));
    }

    @RequestMapping("/crypto")
    public String payWithCrypto(){
        return paymentService.processPayment(new CryptoPayment("0xABC123", 300));
    }
}
