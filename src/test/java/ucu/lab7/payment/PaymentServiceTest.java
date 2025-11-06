package ucu.lab7.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    void testPayPalPayment() {
        PaymentService service = new PaymentService();
        String result = service.processPayment(PaymentType.PAYPAL, 150.75);
        assertTrue(result.contains("PayPal payment"));
        assertTrue(result.contains("150.75"));
    }

    @Test
    void testCreditCardPayment() {
        PaymentService service = new PaymentService();
        String result = service.processPayment(PaymentType.CREDIT_CARD, 99.99);
        assertTrue(result.contains("credit card payment"));
        assertTrue(result.contains("John Doe"));
        assertTrue(result.contains("99.99"));
    }

    @Test
    void testAvailableMethods() {
        PaymentService service = new PaymentService();
        String[] methods = service.getAvailableMethods();
        assertArrayEquals(new String[]{"PAYPAL", "CREDIT_CARD"}, methods);
    }
}
