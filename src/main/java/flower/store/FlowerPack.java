package flower.store;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FlowerPack {
    private Flower flower;
    private int quantity;
     
    public FlowerPack(final Flower flower, final int quantity) {
        this.flower = new Flower(flower);
        this.quantity = quantity;
    }
    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}
