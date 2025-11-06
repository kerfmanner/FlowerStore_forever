package ucu.lab7.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ucu.lab7.item.Item;

class ItemDecoratorTest {

    private Item baseItem(double price) {
        return new Item("Test bouquet") {
            @Override
            public double price() {
                return price;
            }
        };
    }

    @Test
    void paperDecoratorAddsCostAndDescription() {
        Item paperWrapped = new PaperDecorator(baseItem(25));

        assertTrue(paperWrapped instanceof ItemDecorator,
                "PaperDecorator must extend ItemDecorator to follow the pattern");
        assertEquals(38, paperWrapped.price(), 0.0001);
        assertEquals("Test bouquet with paper.", paperWrapped.getDescription());
    }

    @Test
    void ribbonDecoratorAddsCostAndDescription() {
        Item ribbonWrapped = new RibbonDecorator(baseItem(50));

        assertTrue(ribbonWrapped instanceof ItemDecorator,
                "RibbonDecorator must extend ItemDecorator to follow the pattern");
        assertEquals(90, ribbonWrapped.price(), 0.0001);
        assertEquals("Test bouquet with ribbon.", ribbonWrapped.getDescription());
    }

    @Test
    void decoratorsCanBeStacked() {
        Item decorated = new RibbonDecorator(new PaperDecorator(new BasketDecorator(baseItem(10))));

        assertEquals(67, decorated.price(), 0.0001);
        assertEquals("Test bouquet with basket with paper. with ribbon.", decorated.getDescription());
    }
}
