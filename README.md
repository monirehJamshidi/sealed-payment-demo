# Sealed Payment Demo

[🇮🇷 فارسی](./README.fa.md) | [🇩🇪 Deutsch](./README.de.md)

## English 🇬🇧

### Overview
This is a Spring Boot project demonstrating the use of **sealed classes** in Java.  
The project models different types of payments (`CreditCard`, `PayPal`, `Crypto`) and processes them through a REST API.

### Technologies
- Java 21 (or Java 17 with preview features)
- Spring Boot 3
- Maven


### Endpoints
- GET /payments/credit → Simulates a credit card payment
- GET /payments/paypal → Simulates a PayPal payment
- GET /payments/crypto → Simulates a crypto payment


### How to Run
```bash
mvn spring-boot:run
