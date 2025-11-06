package ucu.lab7.decorator;

import ucu.lab7.item.Item;

public class BasketDecorator extends ItemDecorator {

    public BasketDecorator(Item item) {
        super(item, " with basket");
    }

    public double price() {
        return 4 + item.price();
    } 
}
