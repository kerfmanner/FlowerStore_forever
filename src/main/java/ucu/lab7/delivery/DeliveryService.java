package ucu.lab7.delivery;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import ucu.lab7.item.Item;

@Service
public class DeliveryService {

    public String deliver(DeliveryType type, LinkedList<Item> items) {
        Delivery delivery;

        if (type == null) {
            throw new IllegalArgumentException("Delivery type cannot be null");
        }

        switch (type) {
            case DHL -> delivery = new DHLDeliveryStrategy();
            case POST -> delivery = new PostDeliveryStrategy();
            default -> throw new IllegalArgumentException("Unsupported delivery type: " + type);
        }

        return delivery.deliver(items);
    }

    public List<String> getAvailableMethods() {
        return List.of("DHL", "POST");
    }
}
