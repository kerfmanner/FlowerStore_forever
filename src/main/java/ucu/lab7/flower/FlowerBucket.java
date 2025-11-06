package ucu.lab7.flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ucu.lab7.item.Item;

public class FlowerBucket extends Item {

    private List<FlowerPack> flowerPacks;

    public List<FlowerPack> getFlowerPacks() {
        return new ArrayList<>(this.flowerPacks);
    }
    public FlowerBucket() {
        this("No description");
    }

    public FlowerBucket(String description) {
        super(description);
        flowerPacks = new ArrayList<FlowerPack>();
    }

    public void add(FlowerPack flowerPack) {
        if (flowerPacks == null) {
            flowerPacks = new ArrayList<FlowerPack>();
        }
        flowerPacks.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack i : flowerPacks) {
            price += i.getPrice();
        }
        return price;
    }

    public void clear() {
        flowerPacks = new ArrayList<FlowerPack>();
    }

    @Override
    public double price() {
        return getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof FlowerBucket))
            return false;
        FlowerBucket that = (FlowerBucket) o;
        return Objects.equals(flowerPacks, that.flowerPacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowerPacks);
    }

    @Override
    public String toString() {
        return "FlowerBucket{" +
                "flowerPacks=" + flowerPacks +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
