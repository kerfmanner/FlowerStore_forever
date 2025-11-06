package ucu.lab7.flower;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ucu.lab7.item.Item;

@ToString
@Entity
@Table(name = "flowers")
public class Flower extends Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private FlowerStats stats;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private double sepalLength;

    public Flower(String description) {
        super(description);
        stats = new FlowerStats();
        price = 0.0;
        sepalLength = 0.0;
    }

    public FlowerStats getStats() {
        return new FlowerStats(this.stats);
    }

    public void setStats(FlowerStats stats) {
        this.stats = new FlowerStats(stats);
    }
    public Flower() {
        this("");
    }

    public Flower(double price, double sepalLength, FlowerColor color, FlowerType type, String description) {
        super(description);
        this.sepalLength = sepalLength;
        this.price = price;
        this.stats = new FlowerStats(color, type);
    }

    public Flower(double price, double sepalLength, FlowerColor color, FlowerType type) {
        this(price, sepalLength, color, type, "");
    }

    public Flower(Flower flower, String description) {
        super(description);
        this.sepalLength = flower.sepalLength;
        this.price = flower.price;
        this.stats = new FlowerStats(flower.stats);
    }

    public Flower(Flower flower) {
        this(flower, "");
    }

    
    public void setFlowerType(FlowerType type) {
        stats.setFlowerType(type);
    }

    @JsonIgnore
    public FlowerType getFlowerType() {
        return stats.getFlowerType();
    }

    public void setColor(FlowerColor color) {
        stats.setColor(color);
    }

    @JsonIgnore
    public FlowerColor getColor() {
        return stats.getColor();
    }

    @Override
    public double price() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Flower))
            return false;
        Flower f = (Flower) o;
        return Double.compare(f.price, price) == 0 &&
                Double.compare(f.sepalLength, sepalLength) == 0 &&
                Objects.equals(f.stats, stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stats, price, sepalLength);
    }
}
