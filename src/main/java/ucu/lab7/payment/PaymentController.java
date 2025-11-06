package ucu.lab7.payment;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Locale;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/")
    public String[] getPaymentMethods() {
        return paymentService.getAvailableMethods();
    }

    @GetMapping("/{method}")
    public ResponseEntity<String> pay(
            @PathVariable("method") String method,
            @RequestParam(defaultValue = "100.0") double amount) {

        String normalized = method.toUpperCase(Locale.ROOT);

        try {
            PaymentType type = PaymentType.valueOf(normalized);
            String result = paymentService.processPayment(type, amount);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid payment method: " + method);
        }
    }
}
