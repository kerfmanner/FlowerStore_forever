package ucu.lab7.delivery;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import ucu.lab7.flower.Flower;
import ucu.lab7.flower.FlowerColor;
import ucu.lab7.flower.FlowerType;
import ucu.lab7.item.Item;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/")
    public List<String> getDeliveryMethods() {
        return deliveryService.getAvailableMethods();
    }

    @GetMapping("/{method}")
    public ResponseEntity<String> deliver(
            @PathVariable("method") String method,
            @RequestParam(required = false, defaultValue = "2") int itemsCount) {

        String normalized = method.toUpperCase(Locale.ROOT);

        LinkedList<Item> items = new LinkedList<>();
        for (int i = 0; i < itemsCount; i++) {
            items.add(new Flower(12, 10.0 + i, FlowerColor.RED, FlowerType.ROSE, "Test flower " + (i + 1)));
        }

        try {
            DeliveryType type = DeliveryType.valueOf(normalized);
            String result = deliveryService.deliver(type, items);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid delivery method: " + method);
        }
    }
}
