package ucu.lab7.delivery;

import org.junit.jupiter.api.Test;
import ucu.lab7.flower.Flower;
import ucu.lab7.flower.FlowerColor;
import ucu.lab7.flower.FlowerType;
import ucu.lab7.item.Item;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {

    @Test
    void testDHLDeliveryService() {
        DeliveryService service = new DeliveryService();

        LinkedList<Item> items = new LinkedList<>();
        items.add(new Flower(12, 25.0, FlowerColor.RED, FlowerType.ROSE, "Rose"));

        String result = service.deliver(DeliveryType.DHL, items);

        assertTrue(result.startsWith("DHL delivery scheduled"));
        assertTrue(result.contains("Rose"));
    }

    @Test
    void testPostDeliveryService() {
        DeliveryService service = new DeliveryService();

        LinkedList<Item> items = new LinkedList<>();
        items.add(new Flower(10, 22.5, FlowerColor.WHITE, FlowerType.CHAMOMILE, "Chamomile"));

        String result = service.deliver(DeliveryType.POST, items);

        assertTrue(result.startsWith("Post delivery scheduled"));
        assertTrue(result.contains("Chamomile"));
    }

    @Test
    void testInvalidTypeThrows() {
        DeliveryService service = new DeliveryService();

        assertThrows(IllegalArgumentException.class, () ->
                service.deliver(null, new LinkedList<>()));
    }

    @Test
    void testGetAvailableMethods() {
        DeliveryService service = new DeliveryService();
        var methods = service.getAvailableMethods();

        assertTrue(methods.contains("DHL"));
        assertTrue(methods.contains("POST"));
    }
}
