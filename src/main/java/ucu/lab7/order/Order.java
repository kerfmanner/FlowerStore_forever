package ucu.lab7.order;

import java.util.LinkedList;
import ucu.lab7.delivery.Delivery;
import ucu.lab7.item.Item;
import ucu.lab7.payment.Payment;

public class Order {
    private final LinkedList<Item> items = new LinkedList<>();
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(Item::price)
                .sum();
    }

    public void processOrder() {
        if (payment == null || delivery == null) {
            throw new IllegalStateException("Payment or delivery strategy not set!");
        }

        double total = calculateTotalPrice();
        System.out.println("Processing order, total = " + total);
        payment.pay(total);
        delivery.deliver(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public LinkedList<Item> getItems() {
        return new LinkedList<>(items);
    }
}