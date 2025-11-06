package ucu.lab7.decorator;

import ucu.lab7.item.Item;

public abstract class ItemDecorator extends Item {
    protected final Item item;

    protected ItemDecorator(Item item, String extra) {
        super(item.getDescription() + extra);
        this.item = item;
    }

    public abstract double price();
}
