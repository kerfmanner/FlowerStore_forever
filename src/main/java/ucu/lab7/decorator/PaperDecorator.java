package ucu.lab7.decorator;

import ucu.lab7.item.Item;

public class PaperDecorator extends ItemDecorator {

    public PaperDecorator(Item item) {
        super(item, " with paper.");
    }

    public double price() {
        return 13 + item.price();
    } 
}
