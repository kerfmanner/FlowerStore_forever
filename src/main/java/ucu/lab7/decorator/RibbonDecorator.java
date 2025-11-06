package ucu.lab7.decorator;

import ucu.lab7.item.Item;

public class RibbonDecorator extends ItemDecorator{
    
    public RibbonDecorator(Item item) {
        super(item, " with ribbon.");
    }

    public double price() {
        return 40 + item.price();
    } 
}
