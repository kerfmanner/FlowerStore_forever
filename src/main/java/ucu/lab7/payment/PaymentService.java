package ucu.lab7.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment(PaymentType type, double amount) {
        Payment payment;

        switch (type) {
            case PAYPAL -> payment = new PayPalPaymentStrategy("user@example.com");
            case CREDIT_CARD -> payment = new CreditCardPaymentStrategy("1234567812345678", "John Doe");
            default -> throw new IllegalArgumentException("Unsupported payment type: " + type);
        }

        return payment.pay(amount);
    }

    public String[] getAvailableMethods() {
        return new String[]{"PAYPAL", "CREDIT_CARD"};
    }
}
