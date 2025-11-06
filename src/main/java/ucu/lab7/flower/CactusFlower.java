package ucu.lab7.flower;

public class CactusFlower extends Flower {
    
    public CactusFlower(double price, double sepalLength, FlowerColor color, String description){
        super(price, sepalLength, color, FlowerType.CACTUS, description);
    }

    public CactusFlower(double price, double sepalLength, FlowerColor color){
        this(price, sepalLength, color, "");
    }

}
