package ucu.lab7.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentStrategyTest {

    @Test
    void testPayPalPaymentStrategy() {
        Payment payment = new PayPalPaymentStrategy("test@example.com");
        String result = payment.pay(250.5);
        assertTrue(result.contains("PayPal"));
        assertTrue(result.contains("test@example.com"));
        assertTrue(result.contains("250.50"));
    }

    @Test
    void testCreditCardPaymentStrategy() {
        Payment payment = new CreditCardPaymentStrategy("1234567812349999", "Alice");
        String result = payment.pay(89.9);
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("9999"));
        assertTrue(result.contains("89.90"));
    }
}
