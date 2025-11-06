package ucu.lab7.delivery;

import java.util.LinkedList;
import java.util.stream.Collectors;
import ucu.lab7.item.Item;

public class PostDeliveryStrategy implements Delivery {
    @Override
    public String deliver(LinkedList<Item> items) {
        String itemList = items.stream()
                .map(Item::getDescription)
                .collect(Collectors.joining(", "));
        return "Post delivery scheduled for " + items.size() + " item(s): " + itemList + ".";
    }
}