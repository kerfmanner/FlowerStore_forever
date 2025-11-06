package ucu.lab7.delivery;

import org.junit.jupiter.api.Test;
import ucu.lab7.flower.Flower;
import ucu.lab7.flower.FlowerColor;
import ucu.lab7.flower.FlowerType;
import ucu.lab7.item.Item;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStrategyTest {

    @Test
    void testDHLDeliveryStrategy() {
        Delivery strategy = new DHLDeliveryStrategy();
        LinkedList<Item> items = new LinkedList<>();
        items.add(new Flower(12, 25.1, FlowerColor.RED, FlowerType.ROSE, "Red Rose"));
        items.add(new Flower(10, 30.2, FlowerColor.WHITE, FlowerType.CHAMOMILE, "White Chamomile"));

        String result = strategy.deliver(items);

        assertNotNull(result);
        assertTrue(result.contains("DHL delivery scheduled for 2 item(s)"));
        assertTrue(result.contains("Red Rose"));
        assertTrue(result.contains("White Chamomile"));
    }

    @Test
    void testPostDeliveryStrategy() {
        Delivery strategy = new PostDeliveryStrategy();
        LinkedList<Item> items = new LinkedList<>();
        items.add(new Flower(8, 15.0, FlowerColor.YELLOW, FlowerType.TULIP, "Yellow Tulip"));

        String result = strategy.deliver(items);

        assertNotNull(result);
        assertTrue(result.contains("Post delivery scheduled for 1 item(s)"));
        assertTrue(result.contains("Yellow Tulip"));
    }

    @Test
    void testEmptyItemsList() {
        Delivery dhl = new DHLDeliveryStrategy();
        Delivery post = new PostDeliveryStrategy();

        LinkedList<Item> empty = new LinkedList<>();

        assertTrue(dhl.deliver(empty).contains("0 item(s)"));
        assertTrue(post.deliver(empty).contains("0 item(s)"));
    }
}
