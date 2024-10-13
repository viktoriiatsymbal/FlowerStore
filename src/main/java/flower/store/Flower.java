package flower.store;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @AllArgsConstructor @ToString @NoArgsConstructor @Setter
public class Flower {
    private FlowerType flowerType;
    private double price;
    private double sepalLength;
    private FlowerColor color;

    public Flower(Flower flower) {
        this.flowerType = flower.flowerType;
        this.price = flower.price;
        this.sepalLength = flower.sepalLength;
        this.color = flower.color;
    }
    public void setPrice(final int newPrice) {
        this.price = newPrice;
    }
    public String getColor() {
        return color.toString();
    }
}
