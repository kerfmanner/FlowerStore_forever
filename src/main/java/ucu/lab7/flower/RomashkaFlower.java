package ucu.lab7.flower;

public class RomashkaFlower extends Flower {
    public RomashkaFlower(double price, double sepalLength, FlowerColor color, String description){
        super(price, sepalLength, color, FlowerType.CHAMOMILE, description);
    }

    public RomashkaFlower(double price, double sepalLength, FlowerColor color){
        this(price, sepalLength, color, "");
    }
}
